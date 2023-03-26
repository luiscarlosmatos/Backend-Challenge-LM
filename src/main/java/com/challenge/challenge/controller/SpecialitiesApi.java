package com.challenge.challenge.controller;


import com.challenge.challenge.dto.SpecialityWithMaxPatientsDTO;
import com.challenge.challenge.service.PatientsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialities")
@AllArgsConstructor
public class SpecialitiesApi {

    @Autowired
    private PatientsService patientsService;

    @GetMapping(value = "/maxPatients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpecialityWithMaxPatientsDTO>> findSpecialityWithMaxPatients() {
        return ResponseEntity.ok(patientsService.findSpecialityWithMaxPatients());
    }
}
