package com.challenge.challenge.controller;

import com.challenge.challenge.dao.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;


//    @GetMapping(path = "/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Speciality> getAllDoctors() {
//
//        return specialityRepository.findAll();
//    }
}
