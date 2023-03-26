package com.challenge.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface SpecialityWithMaxPatientsDTO {

    String getSpecialityName();
    Integer getNumberOfPatients();
}
