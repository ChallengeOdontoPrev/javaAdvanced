package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.Appointment;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    @NotNull
    private LocalDate dateAppointment;
    @NotNull
    private LocalTime timeAppointment;
    private LocalDateTime createdAt;
    @NotNull
    private Long patientId;
    @NotNull
    private Long userId;
    private Long clinicId;
    @NotNull
    private Long procedureOdontoId;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.dateAppointment = appointment.getDateAppointment();
        this.timeAppointment = appointment.getTimeAppointment();
        this.createdAt = appointment.getCreatedAt();
        this.patientId = appointment.getPatient().getId();
        this.userId = appointment.getUser().getId();
        this.clinicId = appointment.getClinic().getId();
        this.procedureOdontoId = appointment.getProcedureOdonto().getId();
    }
}
