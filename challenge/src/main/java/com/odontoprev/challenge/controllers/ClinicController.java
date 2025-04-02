package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.ClinicDTO;
import com.odontoprev.challenge.domain.projection.AuditProjection;
import com.odontoprev.challenge.services.models.ClinicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public ResponseEntity<ClinicDTO> insert(@RequestBody @Valid ClinicDTO clinicDTO) {
        ClinicDTO clinic = clinicService.insert(clinicDTO);
        return ResponseEntity.ok(clinic);
    }

    @GetMapping
    public ResponseEntity<List<ClinicDTO>> findAll() {
        List<ClinicDTO> clinics = clinicService.findAll();
        return ResponseEntity.ok(clinics);
    }

    @GetMapping("/clinicsAudit")
    public ResponseEntity<List<AuditProjection>> findAllClinicAudits() {
        return ResponseEntity.ok(this.clinicService.findAllClinicAudits());
    }

}
