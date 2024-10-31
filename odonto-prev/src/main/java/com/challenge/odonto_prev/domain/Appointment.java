package com.challenge.odonto_prev.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateAppointment;
    private String timeAppointment;
    private LocalDateTime createdAt;

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
}