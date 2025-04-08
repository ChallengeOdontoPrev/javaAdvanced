package com.odontoprev.challenge.controllers;

import com.odontoprev.challenge.domain.dto.ProcedureStatusDTO;
import com.odontoprev.challenge.services.models.ProcedureStatusService;
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
        ProcedureStatusDTO procedureStatus = procedureStatusService.insert(procedureStatusDTO);
        return ResponseEntity.ok(procedureStatus);
    }

    @PostMapping("/withProcedure")
    public ResponseEntity insertWithProcedure(@RequestBody @Valid ProcedureStatusDTO procedureStatusDTO) {
        this.procedureStatusService.insertWithProcedure(procedureStatusDTO);
        return ResponseEntity.ok("Status de Procedimento inserido com sucesso !!");
    }

    @PutMapping("/withProcedure")
    public ResponseEntity updateWithProcedure(@RequestBody @Valid ProcedureStatusDTO procedureStatusDTO) {
        this.procedureStatusService.updateWithProcedure(procedureStatusDTO);
        return ResponseEntity.ok("Status de Procedimento atualizado com sucesso !!");
    }

    @DeleteMapping("/withProcedure/{id}")
    public ResponseEntity deleteWithProcedure(@PathVariable Long id) {
        this.procedureStatusService.deleteWithProcedure(id);
        return ResponseEntity.ok("Status de Procedimento deletado com sucesso !!");
    }

    @GetMapping
    public ResponseEntity<List<ProcedureStatusDTO>> findAll() {
        List<ProcedureStatusDTO> proceduresStatus = procedureStatusService.findAll();
        return ResponseEntity.ok(proceduresStatus);
    }
}
