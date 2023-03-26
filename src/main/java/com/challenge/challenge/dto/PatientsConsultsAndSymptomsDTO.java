package com.challenge.challenge.dto;

import com.challenge.challenge.entity.Consult;
import com.challenge.challenge.entity.Symptom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientsConsultsAndSymptomsDTO {

    List<ConsultDTO> consults = new ArrayList<>();
    List<SymptomDTO> symptoms = new ArrayList<>();
}
