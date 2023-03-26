package com.challenge.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
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

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathologyName() {
        return pathologyName;
    }

    public void setPathologyName(String pathologyName) {
        this.pathologyName = pathologyName;
    }

    public List<Symptom> getPathologySymptoms() {
        return pathologySymptoms;
    }

    public void setPathologySymptoms(List<Symptom> pathologySymptoms) {
        this.pathologySymptoms = pathologySymptoms;
    }
}
