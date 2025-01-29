package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.ProcedureStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureStatusDTO extends RepresentationModel<ProcedureStatusDTO> {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ProcedureStatusDTO(ProcedureStatus procedureStatus) {
        this.id = procedureStatus.getId();
        this.name = procedureStatus.getName();
        this.description = procedureStatus.getDescription();
    }

    public ProcedureStatusDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
