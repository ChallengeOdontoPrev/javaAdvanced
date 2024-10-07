package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.PatientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String rg;
    private LocalDate birthDate;
    @Column(unique = true)
    private Long numCard;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(PatientDTO patientDTO) {
        this.id = patientDTO.getId();
        this.name = patientDTO.getName();
        this.rg = patientDTO.getRg();
        this.birthDate = patientDTO.getBirthDate();
        this.numCard = patientDTO.getNumCard();
        this.createdAt = LocalDateTime.now();
    }
}
