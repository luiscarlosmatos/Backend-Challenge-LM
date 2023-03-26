package com.challenge.challenge.dto;

import com.challenge.challenge.entity.Pathology;
import com.challenge.challenge.entity.Patient;
import com.challenge.challenge.enums.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultCreationDTO {

    private SpecialityEnum speciality;
    private PatientDTO patient;
    private String doctorName;
    private PathologyDTO pathology;
}
