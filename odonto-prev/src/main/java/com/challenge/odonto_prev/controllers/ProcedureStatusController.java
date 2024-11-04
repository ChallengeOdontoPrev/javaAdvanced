package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.ProcedureStatusDTO;
import com.challenge.odonto_prev.services.ProcedureStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/proceduresStatus")
public class ProcedureStatusController {

    @Autowired
    private ProcedureStatusService procedureStatusService;

    @PostMapping
    public ResponseEntity<ProcedureStatusDTO> insert(@RequestBody @Valid ProcedureStatusDTO procedureStatusDTO) {
        ProcedureStatusDTO procedureStatus = procedureStatusService.insert(procedureStatusDTO);
        procedureStatus.add(linkTo(methodOn(ProcedureStatusController.class).findAll()).withRel("find all"));
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
        proceduresStatus.forEach(procedureStatus ->
                procedureStatus.add(linkTo(methodOn(ProcedureStatusController.class).insert(new ProcedureStatusDTO())).withRel("Insert"))
        );
        return ResponseEntity.ok(proceduresStatus);
    }
}
