package com.challenge.challenge.controller;


import com.challenge.challenge.entity.Consult;
import com.challenge.challenge.service.ConsultsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consults")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
@Log
public class ConsultsApi {

    @Autowired
    private ConsultsService consultsService;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Consult> getConsultById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(consultsService.getConsultById(id));

    }

    @PostMapping
    public ResponseEntity<Consult> createConsult(@RequestBody Consult consultToCreate) {

        Consult consult = consultsService.createConsult(consultToCreate);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consult.getId())
                .toUri();
        return ResponseEntity.created(uri).body(consult);
    }
}
