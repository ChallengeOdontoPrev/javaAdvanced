package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureStatusDTO;
import com.challenge.odonto_prev.services.ProcedureStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proceduresStatus")
public class ProcedureStatusController {

    @Autowired
    private ProcedureStatusService procedureStatusService;

    @PostMapping
    public ResponseEntity<ProcedureStatusDTO> insert(@RequestBody @Valid ProcedureStatusDTO procedureStatusDTO) {
        return ResponseEntity.ok(procedureStatusService.insert(procedureStatusDTO));
    }

    @GetMapping
    public List<ProcedureStatusDTO> findAll() {
        return procedureStatusService.findAll();
    }
}
