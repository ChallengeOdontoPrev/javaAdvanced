package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.ProcedureType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureTypeDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ProcedureTypeDTO(ProcedureType procedureType){
        this.id = procedureType.getId();
        this.name = procedureType.getName();
        this.description = procedureType.getDescription();
    }
}
