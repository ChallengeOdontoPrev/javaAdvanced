package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.ProcedureStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureStatusDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ProcedureStatusDTO(ProcedureStatus procedureStatus){
        this.id = procedureStatus.getId();
        this.name = procedureStatus.getName();
        this.description = procedureStatus.getDescription();
    }
}
