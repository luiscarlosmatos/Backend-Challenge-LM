package com.challenge.challenge.entity;


import com.challenge.challenge.enums.SpecialityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consults")
@Builder
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consults_seq")
    @SequenceGenerator(name="consults_seq", sequenceName="consults_seq", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @Column(name = "consult_speciality")
    @Enumerated(EnumType.STRING)
    private SpecialityEnum speciality;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pathology_id")
    private Pathology pathology;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public SpecialityEnum getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityEnum speciality) {
        this.speciality = speciality;
    }

    public Pathology getPathology() {
        return pathology;
    }

    public void setPathology(Pathology pathology) {
        this.pathology = pathology;
    }
}
