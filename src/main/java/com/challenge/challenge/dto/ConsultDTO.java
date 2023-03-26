package com.challenge.challenge.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultDTO {

    private Long consultId;
    private String doctor;
    private String speciality;
}
