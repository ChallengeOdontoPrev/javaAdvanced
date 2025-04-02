package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.PatientDTO;
import com.odontoprev.challenge.services.models.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> insert(@RequestBody @Valid PatientDTO patientDTO) {
        PatientDTO patient = patientService.insert(patientDTO);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/withProcedure")
    public ResponseEntity insertWithProcedure(@RequestBody @Valid PatientDTO patientDTO) {
        this.patientService.insertWithProcedure(patientDTO);
        return ResponseEntity.ok("Paciente inserido com sucesso !!");
    }

    @PutMapping("/withProcedure")
    public ResponseEntity updateWithProcedure(@RequestBody @Valid PatientDTO patientDTO) {
        this.patientService.updateWithProcedure(patientDTO);
        return ResponseEntity.ok("Paciente atualizado com sucesso !!");
    }

    @DeleteMapping("/withProcedure/{id}")
    public ResponseEntity deleteWithProcedure(@PathVariable Long id) {
        this.patientService.deleteWithProcedure(id);
        return ResponseEntity.ok("Paciente deletado com sucesso !!");
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() {
        List<PatientDTO> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{rg}")
    public ResponseEntity<PatientDTO> findByRg(@PathVariable String rg) {
        PatientDTO patient = patientService.findByRg(rg);
        return ResponseEntity.ok(patient);
    }


}
