package com.challenge.odonto_prev.controllers;

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
    public ResponseEntity<AppointmentDTO> insert(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        AppointmentDTO appointment = appointmentService.insert(appointmentDTO);
        appointment.add(linkTo(methodOn(AppointmentController.class).findById(appointment.getId())).withSelfRel());
        appointment.add(linkTo(methodOn(AppointmentController.class).findAll()).withRel("find all"));
        appointment.add(linkTo(methodOn(AppointmentController.class).delete(appointment.getId())).withRel("delete by id"));
        return ResponseEntity.ok(appointment);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        List<AppointmentResponseDTO> appointments = appointmentService.findAll().stream().map(AppointmentResponseDTO::new).toList();
        appointments.forEach(appointment -> {
            appointment.add(linkTo(methodOn(AppointmentController.class).findById(appointment.getId())).withSelfRel());
            appointment.add(linkTo(methodOn(AppointmentController.class).delete(appointment.getId())).withRel("delete by id"));
        });
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> findById(@PathVariable Long id) {
        AppointmentResponseDTO appointment = new AppointmentResponseDTO(appointmentService.findById(id));
        appointment.add(linkTo(methodOn(AppointmentController.class).findAll()).withRel("all-appointments"));
        appointment.add(linkTo(methodOn(AppointmentController.class).delete(id)).withRel("delete by id"));
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok("Consulta deletada com sucesso");
    }
}
