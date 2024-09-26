package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ClinicaDTO;
import com.challenge.odonto_prev.services.ClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @PostMapping
    public ResponseEntity<ClinicaDTO> insert(@RequestBody @Valid ClinicaDTO clinicaDTO){
        return ResponseEntity.ok(clinicaService.insert(clinicaDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClinicaDTO>> findAll(){
        return ResponseEntity.ok(clinicaService.findAll());
    }

}
