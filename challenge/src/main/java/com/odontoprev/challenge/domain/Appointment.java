package com.odontoprev.challenge.domain;

import com.odontoprev.challenge.enums.AppointmentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateAppointment;
    private String timeAppointment;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private User user;
    @ManyToOne
    private Clinic clinic;
    @OneToOne
    private ProcedureValidation procedureValidation;
    @ManyToOne
    private ProcedureType procedureType;


    public Appointment() {
    }

    public Appointment(Long id, LocalDate dateAppointment, String timeAppointment, LocalDateTime createdAt, Patient patient, User user, Clinic clinic, ProcedureValidation procedureValidation, ProcedureType procedureType) {
        this.id = id;
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.createdAt = createdAt;
        this.patient = patient;
        this.user = user;
        this.clinic = clinic;
        this.procedureValidation = procedureValidation;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public ProcedureValidation getProcedureValidation() {
        return procedureValidation;
    }

    public void setProcedureValidation(ProcedureValidation procedureValidation) {
        this.procedureValidation = procedureValidation;
    }

    public ProcedureType getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(ProcedureType procedureType) {
        this.procedureType = procedureType;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}