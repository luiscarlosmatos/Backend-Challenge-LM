package com.challenge.challenge.dto;

import com.challenge.challenge.enums.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
