package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.ClinicDTO;
import com.odontoprev.challenge.services.ClinicService;
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
        clinic.add(linkTo(methodOn(ClinicController.class).findAll()).withRel("find all"));
        return ResponseEntity.ok(clinic);
    }

    @GetMapping
    public ResponseEntity<List<ClinicDTO>> findAll() {
        List<ClinicDTO> clinics = clinicService.findAll();
        clinics.forEach(clinic -> clinic.add(linkTo(methodOn(ClinicController.class).insert(new ClinicDTO())).withRel("Insert")));
        return ResponseEntity.ok(clinics);
    }

}
