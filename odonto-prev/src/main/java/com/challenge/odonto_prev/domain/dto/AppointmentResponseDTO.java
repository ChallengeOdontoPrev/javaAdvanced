package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDTO extends RepresentationModel<AppointmentResponseDTO> {
    private Long id;
    private LocalDate dateAppointment;
    private String timeAppointment;
    private LocalDateTime createdAt;
    private String patient;
    private String clinic;
    private Long procedureValidationId;
    private String procedureType;

    public AppointmentResponseDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.dateAppointment = appointment.getDateAppointment();
        this.timeAppointment = appointment.getTimeAppointment();
        this.createdAt = appointment.getCreatedAt();
        this.patient = appointment.getPatient().getName();
        this.clinic = appointment.getClinic().getName();
        this.procedureValidationId = appointment.getProcedureValidation().getId();
        this.procedureType = appointment.getProcedureType().getName();
    }

}
