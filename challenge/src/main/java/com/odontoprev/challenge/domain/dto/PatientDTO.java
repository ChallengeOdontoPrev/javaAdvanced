package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO extends RepresentationModel<PatientDTO> {
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
