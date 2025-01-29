package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.ProcedureValidation;
import com.odontoprev.challenge.enums.ClassDetected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureValidationDTO extends RepresentationModel<ProcedureValidationDTO> {
    private Long id;
    private String imgUrlInitial;
    private String imgUrlFinal;
    private ProcedureTypeDTO procedureType;
    private ProcedureStatusDTO procedureStatus;
    private ClassDetected classInitial;
    private ClassDetected classFinal;

    public ProcedureValidationDTO(ProcedureValidation procedureValidation) {
        this.id = procedureValidation.getId();
        this.imgUrlInitial = procedureValidation.getImgUrlInitial();
        this.imgUrlFinal = procedureValidation.getImgUrlFinal();
        this.procedureType = new ProcedureTypeDTO(procedureValidation.getProcedureType());
        this.procedureStatus = new ProcedureStatusDTO(procedureValidation.getProcedureStatus());
        this.classInitial = procedureValidation.getClassInitial();
        this.classFinal = procedureValidation.getClassFinal();
    }
}
