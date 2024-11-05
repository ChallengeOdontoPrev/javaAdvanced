package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.PatientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_patient")
public class Patient extends People {

    @Column(unique = true)
    private Long numCard;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(PatientDTO patientDTO) {
        this.setId(patientDTO.getId());
        this.setName(patientDTO.getName());
        this.setRg(patientDTO.getRg());
        this.setBirthDate(patientDTO.getBirthDate());
        this.numCard = patientDTO.getNumCard();
        this.setCreatedAt(LocalDate.now());
    }
}
