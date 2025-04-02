package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Appointment;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UpdateAppointmentDTO {
    @NotNull
    private LocalDate dateAppointment;
    @NotNull
    private String timeAppointment;
    @NotNull
    private Long dentistId;
    @NotNull
    private Long procedureTypeId;

    public UpdateAppointmentDTO() {
    }

    public UpdateAppointmentDTO(LocalDate dateAppointment, String timeAppointment, Long dentistId, Long procedureTypeId) {
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.dentistId = dentistId;
        this.procedureTypeId = procedureTypeId;
    }

    public UpdateAppointmentDTO(Appointment appointment) {
        this.dateAppointment = appointment.getDateAppointment();
        this.timeAppointment = appointment.getTimeAppointment();
        this.dentistId = appointment.getUser().getId();
        this.procedureTypeId = appointment.getProcedureType().getId();
    }

    public LocalDate getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(LocalDate dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(String timeAppointment) {
        this.timeAppointment = timeAppointment;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public Long getProcedureTypeId() {
        return procedureTypeId;
    }

    public void setProcedureTypeId(Long procedureTypeId) {
        this.procedureTypeId = procedureTypeId;
    }
}
