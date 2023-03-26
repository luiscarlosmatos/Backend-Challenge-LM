package com.challenge.challenge.dao;

import com.challenge.challenge.entity.Doctor;
import com.challenge.challenge.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByName(String name);
}
