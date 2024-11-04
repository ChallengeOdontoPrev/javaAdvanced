package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.PatientDTO;
import com.challenge.odonto_prev.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientDTO insert(@RequestBody @Valid PatientDTO patientDTO) {
        return patientService.insert(patientDTO);
    }

    @GetMapping
    public List<PatientDTO> findAll() {
        return patientService.findAll();
    }

}
