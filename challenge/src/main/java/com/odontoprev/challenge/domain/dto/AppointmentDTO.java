package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Appointment;
import jakarta.validation.constraints.NotNull;
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
public class AppointmentDTO extends RepresentationModel<AppointmentDTO> {
    private Long id;
    @NotNull
    private LocalDate dateAppointment;
    @NotNull
    private String timeAppointment;
    private LocalDateTime createdAt;
    @NotNull
    private Long patientId;
    private Long clinicId;
    @NotNull
    private Long dentistId;
    private Long procedureValidationId;
    @NotNull
    private Long procedureTypeId;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.dateAppointment = appointment.getDateAppointment();
        this.timeAppointment = appointment.getTimeAppointment();
        this.createdAt = appointment.getCreatedAt();
        this.patientId = appointment.getPatient().getId();
        this.clinicId = appointment.getClinic().getId();
        this.dentistId = appointment.getUser().getId();
        this.procedureValidationId = appointment.getProcedureValidation().getId();
        this.procedureTypeId = appointment.getProcedureType().getId();
    }
}
