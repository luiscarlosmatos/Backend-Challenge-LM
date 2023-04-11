package com.challenge.challenge.service;

import com.challenge.challenge.dao.ConsultsRepository;
import com.challenge.challenge.dao.DoctorRepository;
import com.challenge.challenge.dao.PathologyRepository;
import com.challenge.challenge.dao.PagingPatientRepository;
import com.challenge.challenge.entity.Consult;
import com.challenge.challenge.entity.Pathology;
import com.challenge.challenge.entity.Patient;
import com.challenge.challenge.entity.Symptom;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
@Log
public class ConsultsService {

    @Autowired
    private final ConsultsRepository consultsRepository;

    @Autowired
    private final PagingPatientRepository pagingPatientRepository;

    @Autowired
    private final DoctorRepository doctorRepository;

    @Autowired
    private final PathologyRepository pathologyRepository;


    public Consult getConsultById(Long id) {

        return consultsRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Consult with id:"+id+" does not exist!");
                    return new EntityNotFoundException("Consult with ID=" + id + " not found");
                });

    }

    public Consult createConsult(Consult consult) {

        log.info("Creating consult...");

        Consult consultToSave = new Consult();
        log.info("Getting patient with name:"+consult.getPatient().getName());

        consultToSave.setPatient(
                pagingPatientRepository.findByName(consult.getPatient().getName())
                        .orElseGet(() -> {
                            log.info(" patient with name:"+consult.getPatient().getName()+" does not exists! creating one..");
                            return new Patient(
                                consult.getPatient().getName(),
                                consult.getPatient().getAge());
                        })
        );

        consultToSave.setDoctor(doctorRepository.findByName(consult.getDoctor().getName())
                .orElseThrow(() -> {
                    log.info("Doctor with name:" + consult.getDoctor().getName() + " does not exists!");
                    return new IllegalArgumentException("Doctor with name:" + consult.getDoctor().getName() + " does not exists!");
                })
        );
        consultToSave.setSpeciality(consult.getSpeciality());

        consultToSave.setPathology(
                pathologyRepository.findByPathologyName(consult.getPathology().getPathologyName())
                        .orElseGet(() -> {
                            log.info("creating new Pathology...");
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
