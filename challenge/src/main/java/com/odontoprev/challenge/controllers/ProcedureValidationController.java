package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.ProcedureValidationDTO;
import com.odontoprev.challenge.services.ProcedureValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/proceduresValidation")
public class ProcedureValidationController {

    @Autowired
    private ProcedureValidationService procedureValidationService;

    @GetMapping
    public ResponseEntity<List<ProcedureValidationDTO>> findAll() {
        List<ProcedureValidationDTO> proceduresValidation = procedureValidationService.findAll();
        proceduresValidation.forEach(procedureValidation -> {
            procedureValidation.add(linkTo(methodOn(ProcedureValidationController.class).updateStatus(procedureValidation.getId(), "NEW-STATUS")).withRel("Update Status"));
            procedureValidation.getProcedureStatus().add(linkTo(methodOn(ProcedureStatusController.class).findAll()).withRel("find all"));
            procedureValidation.getProcedureType().add(linkTo(methodOn(ProcedureTypeController.class).findAll()).withRel("find all"));
        });
        return ResponseEntity.ok(proceduresValidation);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProcedureValidationDTO> updateStatus(@PathVariable Long id, @RequestParam String status) {
        ProcedureValidationDTO procedureValidation = procedureValidationService.updateStatus(id, status);
        procedureValidation.add(linkTo(methodOn(ProcedureValidationController.class).findAll()).withRel("find all"));
        procedureValidation.getProcedureStatus().add(linkTo(methodOn(ProcedureStatusController.class).findAll()).withRel("find all"));
        procedureValidation.getProcedureType().add(linkTo(methodOn(ProcedureTypeController.class).findAll()).withRel("find all"));
        return ResponseEntity.ok(procedureValidation);
    }
}
