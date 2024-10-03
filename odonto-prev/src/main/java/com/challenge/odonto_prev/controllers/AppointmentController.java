package com.challenge.odonto_prev.controllers;

import com.challenge.odonto_prev.domain.dto.AppointmentDTO;
import com.challenge.odonto_prev.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<AppointmentDTO> findAll() {
        return appointmentService.findAll();
    }
}
