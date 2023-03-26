package com.challenge.challenge.dao;

import com.challenge.challenge.entity.Doctor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@DataJpaTest
class DoctorRepositoryTest {

    @Autowired
    DoctorRepository doctorRepository;

    @Test
    void findByName() {

        Doctor doctor = Doctor.builder()
                .name("Doctor1")
                .build();

        doctorRepository.save(doctor);

        Optional<Doctor> doctorById = doctorRepository.findById(1L);

        assertTrue(doctorById.isPresent());
        assertEquals(doctorById.get().getName(), doctor.getName());

        Optional<Doctor> doctorByName = doctorRepository.findByName("Doctor1");
        assertTrue(doctorByName.isPresent());
        assertEquals(doctorByName.get().getName(), doctorById.get().getName());
        assertEquals(doctorByName.get().getId(), doctorById.get().getId());

    }
}