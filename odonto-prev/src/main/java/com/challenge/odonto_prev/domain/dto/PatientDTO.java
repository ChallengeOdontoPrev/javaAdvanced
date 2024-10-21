package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.rg = patient.getRg();
        this.birthDate = patient.getBirthDate();
        this.numCard = patient.getNumCard();
        this.createdAt = patient.getCreatedAt();
    }
}
