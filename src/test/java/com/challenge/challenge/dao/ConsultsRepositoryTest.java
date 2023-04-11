package com.challenge.challenge.dao;

import com.challenge.challenge.entity.*;
import com.challenge.challenge.enums.SpecialityEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ConsultsRepositoryTest {

    @Autowired
    private ConsultsRepository consultsRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void findByPatientId() {

        Patient patient = Patient.builder()
                .age(37)
                .name("Luis")
                .build();



        Consult consult1 = Consult.builder()
                .speciality(SpecialityEnum.DERMATOLOGY)
                .doctor(Doctor.builder()
                        .name("António")
                        .build())
                .patient(patient)
                .pathology(Pathology.builder()
                        .pathologyName("Gripe")
                        .pathologySymptoms(Arrays.asList(
                                Symptom.builder()
                                        .symptomDescription("Dor de cabeça")
                                        .build(),
                                Symptom.builder()
                                        .symptomDescription("Dor no corpo")
                                        .build())
                        ).build()
                ).build();

        patientRepository.save(patient);
        doctorRepository.save(consult1.getDoctor());
        consultsRepository.save(consult1);




        Optional<Consult> getConsult = consultsRepository.findById(1L);

        assertTrue(getConsult.isPresent());
        assertEquals(getConsult.get().getId(), consult1.getId());

        List<Consult> byPatientId = consultsRepository.findByPatientId(1L);
        assertEquals(1, byPatientId.size());
        assertEquals(byPatientId.get(0).getId(), consult1.getId());
    }
}