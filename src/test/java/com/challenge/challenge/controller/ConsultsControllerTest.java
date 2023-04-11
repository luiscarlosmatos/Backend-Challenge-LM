package com.challenge.challenge.controller;

import com.challenge.challenge.dao.DoctorRepository;
import com.challenge.challenge.entity.*;
import com.challenge.challenge.enums.SpecialityEnum;
import com.challenge.challenge.service.ConsultsService;
import com.challenge.challenge.service.PatientsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ConsultsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultsService consultsService;

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private PatientsService patientsService;

    @Autowired
    private ObjectMapper objectMapper;

    private Consult consult1;

    @BeforeEach
    void init() {

        MockitoAnnotations.openMocks(this);

        consult1 = Consult.builder()
                .speciality(SpecialityEnum.DERMATOLOGY)
                .doctor(Doctor.builder()
                        .name("António")
                        .build())
                .patient(Patient.builder()
                        .age(37)
                        .name("Luis")
                        .build())
                .pathology(Pathology.builder()
                        .pathologyName("Gripe")
                        .pathologySymptoms(Arrays.asList(
                                Symptom.builder()
                                        .symptomDescription("Dor de cabeça")
                                        .build(),
                                Symptom.builder()
                                        .symptomDescription("Dor no corpo")
                                        .build())
                ).build()
            ).build();

    }

    @Test
    void shouldCreateNewConsult() throws Exception {

        when(consultsService.createConsult(any(Consult.class))).thenReturn(consult1);

        this.mockMvc.perform(post("/api/consults")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(consult1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.doctor.name", is(consult1.getDoctor().getName())))
                .andExpect(jsonPath("$.patient.name", is(consult1.getPatient().getName())));

    }

}
