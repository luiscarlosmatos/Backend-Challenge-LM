package com.challenge.challenge.service;

import com.challenge.challenge.dao.ConsultsRepository;
import com.challenge.challenge.dao.PagingPatientRepository;
import com.challenge.challenge.dto.*;
import com.challenge.challenge.entity.Patient;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientsService {

    @Autowired
    private PagingPatientRepository pagingPatientRepository;

    @Autowired
    private ConsultsRepository consultsRepository;

    public PatientPageDTO getPatients(int pageNo, int pageSize, String sortBy, String sortDir) {

        //build sort object based on received parameters

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        // decrementing the page number to have a more natural user feeling, starting in 1 instead of 0
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);

        Page<Patient> patients = pagingPatientRepository.findAll(pageable);

        // get content for page object
        List<Patient> listOfPatients = patients.getContent();

        List<PatientDTO> content= listOfPatients.stream()
                .map(Patient::mapToDTO).collect(Collectors.toList());

        PatientPageDTO patientPageDTO = new PatientPageDTO();
        patientPageDTO.setContent(content);
        patientPageDTO.setPageNo(patients.getNumber()+1);
        patientPageDTO.setPageSize(patients.getSize());
        patientPageDTO.setTotalElements(patients.getTotalElements());
        patientPageDTO.setTotalPages(patients.getTotalPages());
        patientPageDTO.setLast(patients.isLast());

        return patientPageDTO;
    }

    public PatientsConsultsAndSymptomsDTO getPatientConsultsAndSymptoms(String patientName) {

        Patient patient = pagingPatientRepository.findByName(patientName)
                .orElseThrow(() -> new EntityNotFoundException("Patinent with Name=" + patientName + " does not exists"));

        PatientsConsultsAndSymptomsDTO patientsConsultsAndSymptomsDTO = new PatientsConsultsAndSymptomsDTO();

        // get the patient
        consultsRepository.findByPatientId(patient.getId())
                .forEach(consult -> { //iterates over patient's consults and add it's information to DTO
                    patientsConsultsAndSymptomsDTO.getConsults()
                            .add(ConsultDTO.builder()
                                    .consultId(consult.getId())
                                    .doctor(consult.getDoctor().getName())
                                    .speciality(consult.getSpeciality().getValue())
                                    .build());
                    //iterates over the consult's symptoms and add it's information to the DTO
                    consult.getPathology().getPathologySymptoms()
                            .forEach(symptom -> patientsConsultsAndSymptomsDTO.getSymptoms()
                                    .add(SymptomDTO.builder()
                                            .symptomId(symptom.getId())
                                            .description(symptom.getSymptomDescription())
                                            .build()
                                    ));
                });

        return patientsConsultsAndSymptomsDTO;
    }

    public List<SpecialityWithMaxPatientsDTO> findSpecialityWithMaxPatients(int minCount) {
        return pagingPatientRepository.findSpecialityWithMaxPatients(minCount);
    }

}
