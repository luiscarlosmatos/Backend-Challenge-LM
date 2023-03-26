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
@Data
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


}
