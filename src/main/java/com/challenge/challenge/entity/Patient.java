package com.challenge.challenge.entity;

import com.challenge.challenge.dto.PatientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@Builder
public class Patient {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patients_seq")
    @SequenceGenerator(name="patients_seq", sequenceName="patients_seq", allocationSize = 1)
    private Long id;

    @Column(name = "patient_name")
    private String name;

    @Column(name = "patient_age")
    private Integer age;

    public Patient(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static PatientDTO mapToDTO(Patient patient) {
        return PatientDTO.builder()
                .age(patient.getAge())
                .name(patient.getName())
                .build();
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
