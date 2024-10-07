package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureValidationDTO;
import com.challenge.odonto_prev.services.ProcedureValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedureValidation")
public class ProcedureValidationController {

    @Autowired
    private ProcedureValidationService procedureValidationService;

    @GetMapping
    public List<ProcedureValidationDTO> findAll() {
        return procedureValidationService.findAll();
    }

}
