package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureTypeDTO;
import com.challenge.odonto_prev.services.ProcedureTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proceduresType")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @PostMapping
    public ResponseEntity<ProcedureTypeDTO> insert(@RequestBody @Valid ProcedureTypeDTO procedureTypeDTO) {
        return ResponseEntity.ok(procedureTypeService.insert(procedureTypeDTO));
    }

    @GetMapping
    public List<ProcedureTypeDTO> findAll() {
        return procedureTypeService.findAll();
    }
}
