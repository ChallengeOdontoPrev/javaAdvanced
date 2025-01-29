package com.odontoprev.challenge.domain.dto;


import com.odontoprev.challenge.domain.ProcedureType;
import com.odontoprev.challenge.enums.ClassDetected;
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
