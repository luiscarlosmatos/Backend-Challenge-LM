package com.challenge.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pathologies")
@Builder
public class Pathology {

    @Id
    @Column(name = "pathology_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pathologies_seq")
    @SequenceGenerator(name="pathologies_seq", sequenceName="pathologies_seq", allocationSize = 1)
    private Long id;

    @Column(name = "pathology_name")
    private String pathologyName;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Symptom> pathologySymptoms;

}
