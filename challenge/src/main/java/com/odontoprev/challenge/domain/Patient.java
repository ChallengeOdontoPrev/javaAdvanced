package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.PatientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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
