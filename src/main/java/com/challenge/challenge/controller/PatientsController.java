package com.challenge.challenge.controller;


import com.challenge.challenge.dto.PatientPageDTO;
import com.challenge.challenge.dto.PatientsConsultsAndSymptomsDTO;
import com.challenge.challenge.service.PatientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
@Log
@Tag(name = "Patient REST endpoint")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    /**
     * Given the patient name, returns all the consults the patient had attended as well as all the symptoms reported
     *
     * @param patientName refers to the patient name
     * @return a list of consult and a list of symptoms
     */
    @GetMapping(value = "/{patientName}/ConsultsAndSymptoms", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "GET Patient consults",
            description = "Gets consults and symptoms from a patient"
    )
    public ResponseEntity<PatientsConsultsAndSymptomsDTO> getPatientConsultsAndSymptoms(@PathVariable("patientName") String patientName) {
        log.info("Getting consults and symptoms information for patient with name:"+patientName);
        return ResponseEntity.ok(patientsService.getPatientConsultsAndSymptoms(patientName));
    }

    /**
     * List patients in a pagination manner.
     *
     * @param pageNo   page number, default 1
     * @param pageSize refers to the number of items per page, default 10
     * @param sortBy   patient attribute to sort for, default patient id
     * @param sortDir  sort direction, ascending or descending, default ASC
     * @return paginated list of patients
     */
    @GetMapping()
    @Operation(
            summary = "GET Patients",
            description = "List patients in a paginated manner"
    )
    public ResponseEntity<PatientPageDTO> getPatients(
            @RequestParam(value = "pageNo", defaultValue = ApiConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = ApiConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = ApiConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = ApiConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        log.info("Listing patients, page:"+pageNo+" sorted by "+sortBy+" "+sortDir);

        return ResponseEntity.ok(patientsService.getPatients(pageNo, pageSize, sortBy, sortDir));
    }
}
