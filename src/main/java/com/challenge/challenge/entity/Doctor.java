package com.challenge.challenge.entity;

import com.challenge.challenge.enums.SpecialityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
@Builder
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_seq")
    @SequenceGenerator(name="doctors_seq", sequenceName="doctors_seq", allocationSize = 1)
    private Long id;

    @Column(name = "doctor_name")
    private String name;

}
