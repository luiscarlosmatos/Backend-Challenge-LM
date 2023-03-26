package com.challenge.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
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
}
