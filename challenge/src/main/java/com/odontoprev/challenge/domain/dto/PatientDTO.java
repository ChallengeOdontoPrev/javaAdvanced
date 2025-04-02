package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PatientDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String rg;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Long numCard;
    private LocalDate createdAt;

    public PatientDTO() {
    }

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.rg = patient.getRg();
        this.birthDate = patient.getBirthDate();
        this.numCard = patient.getNumCard();
        this.createdAt = patient.getCreatedAt();
    }

    public PatientDTO(String name, Long id, String rg, LocalDate birthDate, Long numCard, LocalDate createdAt) {
        this.name = name;
        this.id = id;
        this.rg = rg;
        this.birthDate = birthDate;
        this.numCard = numCard;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getNumCard() {
        return numCard;
    }

    public void setNumCard(Long numCard) {
        this.numCard = numCard;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
