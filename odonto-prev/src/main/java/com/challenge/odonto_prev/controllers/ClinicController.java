package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ClinicDTO;
import com.challenge.odonto_prev.services.ClinicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public ResponseEntity<ClinicDTO> insert(@RequestBody @Valid ClinicDTO clinicDTO) {
        return ResponseEntity.ok(clinicService.insert(clinicDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClinicDTO>> findAll() {
        return ResponseEntity.ok(clinicService.findAll());
    }

}
