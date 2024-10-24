package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.Appointment;
import com.challenge.odonto_prev.domain.dto.AppointmentDTO;
import com.challenge.odonto_prev.domain.dto.AppointmentResponseDTO;
import com.challenge.odonto_prev.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        List<AppointmentResponseDTO> appointments = appointmentService.findAll().stream().map(AppointmentResponseDTO::new).toList();
        if (appointments.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            for (AppointmentResponseDTO appointment : appointments) {
                Long id = appointment.getId();
                appointment.add(linkTo(methodOn(AppointmentController.class).findById(id)).withSelfRel());
            }
            return ResponseEntity.ok(appointments);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> findById(@PathVariable Long id) {
        AppointmentResponseDTO appointment = new AppointmentResponseDTO(appointmentService.findById(id));
        appointment.add(linkTo(methodOn(AppointmentController.class).findAll()).withRel("all-appointments"));
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok("Consulta deletada com sucesso");
    }
}
