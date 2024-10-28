package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.ProcedureStatus;
import com.challenge.odonto_prev.domain.ProcedureType;
import com.challenge.odonto_prev.domain.ProcedureValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureValidationDTO extends RepresentationModel<ProcedureValidationDTO> {
    private Long id;
    private String imgUrlInitial;
    private String imgUrlFinal;
    private ProcedureTypeDTO procedureType;
    private ProcedureStatusDTO procedureStatus;

    public ProcedureValidationDTO(ProcedureValidation procedureValidation) {
        this.id = procedureValidation.getId();
        this.imgUrlInitial = procedureValidation.getImgUrlInitial();
        this.imgUrlFinal = procedureValidation.getImgUrlFinal();
        this.procedureType = new ProcedureTypeDTO(procedureValidation.getProcedureType());
        this.procedureStatus = new ProcedureStatusDTO(procedureValidation.getProcedureStatus());
    }
}
