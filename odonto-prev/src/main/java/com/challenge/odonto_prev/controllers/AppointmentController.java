package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.AppointmentDTO;
import com.challenge.odonto_prev.domain.dto.AppointmentResponseDTO;
import com.challenge.odonto_prev.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO insert(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return appointmentService.insert(appointmentDTO);
    }

    @GetMapping
    public List<AppointmentResponseDTO> findAll() {
        return appointmentService.findAll().stream().map(AppointmentResponseDTO::new).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok("Consulta deletada com sucesso");
    }
}
