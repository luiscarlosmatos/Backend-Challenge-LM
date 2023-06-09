package com.challenge.challenge.controller;


import com.challenge.challenge.entity.Consult;
import com.challenge.challenge.service.ConsultsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/consults")
@AllArgsConstructor
@NoArgsConstructor
@Log
@Tag(name = "Consult REST endpoint")
public class ConsultsController {

    @Autowired
    private ConsultsService consultsService;

    /**
     * Gets a consult by id.
     * @param id refers to the consultId
     * @return ResponseEntity with http status OK if the consults exists or http NOT_FOUND when doesn´t exist
     */
    @GetMapping(value = "/{consultId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "GET Consult",
            description = "Gets a consult by it's ID"
    )
    public ResponseEntity<Consult> getConsultById(@PathVariable("consultId") Long id) {

        log.info("Getting Consult with ID:"+id);

        return ResponseEntity.ok(consultsService.getConsultById(id));

    }

    /**
     * Creates a consult. It's assumed that the Doctor must be already created, otherwise will return a BAD_REQUEST.
     * other data, patient, symptom and symptom description will be created as well is don't exist.
     *
     * @param consultToCreate contains the consult information to be persisted
     * @return ResponseEntity with http status CREATED if the operation is successful
     */
    @PostMapping
    @Operation(
            summary = "POST Consult",
            description = "Creates a consult"
    )
    public ResponseEntity<Consult> createConsult(@RequestBody Consult consultToCreate) {

        log.info("Creating Consult with data:"+consultToCreate);

        Consult consult = consultsService.createConsult(consultToCreate);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consult.getId())
                .toUri();
        return ResponseEntity.created(uri).body(consult);
    }
}
