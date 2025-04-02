package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Appointment;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentDTO {
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

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long id, LocalDate dateAppointment, String timeAppointment, LocalDateTime createdAt, Long patientId, Long clinicId, Long dentistId, Long procedureValidationId, Long procedureTypeId) {
        this.id = id;
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.createdAt = createdAt;
        this.patientId = patientId;
        this.clinicId = clinicId;
        this.dentistId = dentistId;
        this.procedureValidationId = procedureValidationId;
        this.procedureTypeId = procedureTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public Long getProcedureValidationId() {
        return procedureValidationId;
    }

    public void setProcedureValidationId(Long procedureValidationId) {
        this.procedureValidationId = procedureValidationId;
    }

    public Long getProcedureTypeId() {
        return procedureTypeId;
    }

    public void setProcedureTypeId(Long procedureTypeId) {
        this.procedureTypeId = procedureTypeId;
    }
}
