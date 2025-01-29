package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
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
