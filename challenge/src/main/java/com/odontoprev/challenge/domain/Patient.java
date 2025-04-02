package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.PatientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

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

    public Patient(Long numCard, List<Appointment> appointments) {
        this.numCard = numCard;
        this.appointments = appointments;
    }

    public Patient() {
    }

    public Long getNumCard() {
        return numCard;
    }

    public void setNumCard(Long numCard) {
        this.numCard = numCard;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
