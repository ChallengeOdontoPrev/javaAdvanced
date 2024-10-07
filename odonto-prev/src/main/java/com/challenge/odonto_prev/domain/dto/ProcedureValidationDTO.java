package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.ProcedureValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureValidationDTO {
    private Long id;
    private String imgUrlInitial;
    private String imgUrlFinal;

    public ProcedureValidationDTO(ProcedureValidation procedureValidation) {
        this.id = procedureValidation.getId();
        this.imgUrlInitial = procedureValidation.getImgUrlInitial();
        this.imgUrlFinal = procedureValidation.getImgUrlFinal();
    }
}
