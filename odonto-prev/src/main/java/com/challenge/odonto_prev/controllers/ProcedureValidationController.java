package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureValidationDTO;
import com.challenge.odonto_prev.services.ProcedureValidationService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proceduresValidation")
public class ProcedureValidationController {

    @Autowired
    private ProcedureValidationService procedureValidationService;

    @GetMapping
    public List<ProcedureValidationDTO> findAll() {
        return procedureValidationService.findAll();
    }

    @PatchMapping("/{id}")
    public ProcedureValidationDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
        return procedureValidationService.updateStatus(id, status);
    }
}
