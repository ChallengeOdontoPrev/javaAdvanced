package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.ProcedureTypeDTO;
import com.odontoprev.challenge.services.models.ProcedureTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/proceduresType")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @PostMapping
    public ResponseEntity<ProcedureTypeDTO> insert(@RequestBody @Valid ProcedureTypeDTO procedureTypeDTO) {
        ProcedureTypeDTO procedureType = procedureTypeService.insert(procedureTypeDTO);
        return ResponseEntity.ok(procedureType);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureTypeDTO>> findAll() {
        List<ProcedureTypeDTO> proceduresType = procedureTypeService.findAll();
        return ResponseEntity.ok(proceduresType);
    }
}
