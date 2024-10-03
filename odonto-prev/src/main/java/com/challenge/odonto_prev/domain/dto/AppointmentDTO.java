package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.Appointment;
import com.challenge.odonto_prev.enums.ProcedureEnum;
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
    @NotNull
    private ProcedureEnum procedureEnum;
    @NotNull
    private Long patientId;
    @NotNull
    private Long dentistId;
    private Long clinicId;
    private LocalDateTime createdAt;

    public AppointmentDTO(Appointment appointment){
        this.id = appointment.getId();
        this.dateAppointment = appointment.getDateAppointment();
        this.timeAppointment = appointment.getTimeAppointment();
        this.procedureEnum = appointment.getProcedureEnum();
        this.createdAt = appointment.getCreatedAt();
        this.patientId = appointment.getPatient().getId();
        this.dentistId = appointment.getDentist().getId();
        this.clinicId = appointment.getClinic().getId();
    }
}
