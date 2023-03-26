package com.challenge.challenge.service;

import com.challenge.challenge.dao.ConsultsRepository;
import com.challenge.challenge.dao.DoctorRepository;
import com.challenge.challenge.dao.PathologyRepository;
import com.challenge.challenge.dao.PatientRepository;
import com.challenge.challenge.dto.ConsultCreationDTO;
import com.challenge.challenge.entity.Consult;
import com.challenge.challenge.entity.Pathology;
import com.challenge.challenge.entity.Patient;
import com.challenge.challenge.entity.Symptom;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import javax.management.BadAttributeValueExpException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class ConsultsService {

    @Autowired
    private final ConsultsRepository consultsRepository;

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final DoctorRepository doctorRepository;

    @Autowired
    private final PathologyRepository pathologyRepository;


    public List<Consult> getConsults() {

        return consultsRepository.findAll();
    }


    public Consult getConsultById(Long id) {

        return consultsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consult with ID="+id+" not found"));

    }

    public Consult createConsult(Consult consult)  {

        Consult consultToSave = new Consult();


        consultToSave.setPatient(
                patientRepository.findByName(consult.getPatient().getName())
                        .orElseGet(() -> new Patient(
                                consult.getPatient().getName(),
                                consult.getPatient().getAge()
                        ))
        );

        consultToSave.setDoctor(doctorRepository.findByName(consult.getDoctor().getName())
                .orElseThrow(() -> new IllegalArgumentException("Doctor with name:"+consult.getDoctor().getName()+" does not exists!"))
        );
        consultToSave.setSpeciality(consult.getSpeciality());

        consultToSave.setPathology(
                pathologyRepository.findByPathologyName(consult.getPathology().getPathologyName())
                        .orElseGet(() -> {
                            Pathology newPathology = new Pathology();
                            newPathology.setPathologyName(consult.getPathology().getPathologyName());
                            newPathology.setPathologySymptoms(consult.getPathology().getPathologySymptoms()
                                    .stream()
                                    .map(symptom -> new Symptom(symptom.getSymptomDescription()))
                                    .collect(Collectors.toList()));

                            return newPathology;
                        })
        );


        consultsRepository.save(consultToSave);

        return consultToSave;
    }


}
