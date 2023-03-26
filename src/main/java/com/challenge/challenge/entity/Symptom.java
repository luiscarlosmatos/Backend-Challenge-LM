package com.challenge.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "symptoms")
@Builder
public class Symptom {

    @Id
    @Column(name = "symptom_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "symptoms_seq")
    @SequenceGenerator(name="symptoms_seq", sequenceName="symptoms_seq", allocationSize = 1)
    private Long id;

    @Column(name = "symptom_description")
    private String symptomDescription;

    public Symptom(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymptomDescription() {
        return symptomDescription;
    }

    public void setSymptomDescription(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }
}
