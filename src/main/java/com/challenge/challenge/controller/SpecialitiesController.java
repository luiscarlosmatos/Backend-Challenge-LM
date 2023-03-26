package com.challenge.challenge.controller;


import com.challenge.challenge.dto.SpecialityWithMaxPatientsDTO;
import com.challenge.challenge.service.PatientsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialities")
@AllArgsConstructor
@Log
public class SpecialitiesController {

    @Autowired
    private PatientsService patientsService;

    /**
     * List the specialities that have been used by more than a number of patients
     * @param minPatients number of patients
     * @return a list os items, each one containing the speciality name and the number of patients tha had used it
     */
    @GetMapping(value = "/maxPatients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpecialityWithMaxPatientsDTO>> findSpecialityWithMaxPatients(
            @RequestParam(value = "minPatients", defaultValue = "2", required = true) int minPatients
    ) {
        return ResponseEntity.ok(patientsService.findSpecialityWithMaxPatients(minPatients));
    }
}
