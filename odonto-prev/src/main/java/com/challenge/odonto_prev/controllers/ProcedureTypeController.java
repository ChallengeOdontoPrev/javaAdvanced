package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureTypeDTO;
import com.challenge.odonto_prev.services.ProcedureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proceduresType")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @GetMapping
    public List<ProcedureTypeDTO> findAll() {
        return procedureTypeService.findAll();
    }

}
