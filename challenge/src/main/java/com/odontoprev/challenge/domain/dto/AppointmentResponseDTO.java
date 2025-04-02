package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentResponseDTO {
    private Long id;
    private LocalDate dateAppointment;
    private String timeAppointment;
    private LocalDateTime createdAt;
    private String patient;
    private String clinic;
    private Long procedureValidationId;
    private String procedureType;

    public AppointmentResponseDTO() {
    }

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

    public AppointmentResponseDTO(Long id, LocalDate dateAppointment, String timeAppointment, LocalDateTime createdAt, String patient, String clinic, Long procedureValidationId, String procedureType) {
        this.id = id;
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.createdAt = createdAt;
        this.patient = patient;
        this.clinic = clinic;
        this.procedureValidationId = procedureValidationId;
        this.procedureType = procedureType;
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

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public Long getProcedureValidationId() {
        return procedureValidationId;
    }

    public void setProcedureValidationId(Long procedureValidationId) {
        this.procedureValidationId = procedureValidationId;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }
}
