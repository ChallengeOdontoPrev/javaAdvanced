package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.ProcedureType;
import com.challenge.odonto_prev.enums.ClassDetected;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureTypeDTO extends RepresentationModel<ProcedureTypeDTO> {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private ClassDetected classInitial;
    private ClassDetected classFinal;

    public ProcedureTypeDTO(ProcedureType procedureType) {
        this.id = procedureType.getId();
        this.name = procedureType.getName();
        this.description = procedureType.getDescription();
        this.classInitial = procedureType.getClassInitial();
        this.classFinal = procedureType.getClassFinal();
    }
}
