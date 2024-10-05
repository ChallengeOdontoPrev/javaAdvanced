package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureOdontoDTO;
import com.challenge.odonto_prev.services.ProcedureOdontoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proceduresOdonto")
public class ProcedureOdontoController {

    @Autowired
    private ProcedureOdontoService procedureOdontoService;

    @PostMapping
    public ProcedureOdontoDTO insert(@RequestBody @Valid ProcedureOdontoDTO procedureOdontoDTO) {
        return procedureOdontoService.insert(procedureOdontoDTO);
    }

    @GetMapping
    public List<ProcedureOdontoDTO> findAll() {
        return procedureOdontoService.findAll();
    }

}
