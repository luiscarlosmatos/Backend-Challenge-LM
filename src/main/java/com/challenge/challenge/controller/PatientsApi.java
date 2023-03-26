package com.challenge.challenge.controller;


import com.challenge.challenge.dto.PatientPageDTO;
import com.challenge.challenge.dto.PatientsConsultsAndSymptomsDTO;
import com.challenge.challenge.service.PatientsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientsApi {

    @Autowired
    private PatientsService patientsService;

    @GetMapping(value = "/{patientName}/ConsultsAndSymptoms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientsConsultsAndSymptomsDTO> getPatientConsultsAndSymptoms(@PathVariable("patientName") String patientName) {
        return ResponseEntity.ok(patientsService.getPatientConsultsAndSymptoms(patientName));
    }

    @GetMapping()
    public ResponseEntity<PatientPageDTO> getPatients(
            @RequestParam(value = "pageNo", defaultValue = ApiConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = ApiConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = ApiConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = ApiConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(patientsService.getPatients(pageNo, pageSize, sortBy, sortDir));
    }
}
