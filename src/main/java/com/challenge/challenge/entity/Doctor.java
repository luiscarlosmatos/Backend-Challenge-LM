package com.challenge.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
@Builder
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctors_seq")
    @SequenceGenerator(name = "doctors_seq", sequenceName = "doctors_seq", allocationSize = 1)
    private Long id;

    @Column(name = "doctor_name")
    private String name;

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
}
