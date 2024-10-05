package com.challenge.odonto_prev.domain.dto;

import com.challenge.odonto_prev.domain.ProcedureOdonto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureOdontoDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ProcedureOdontoDTO(ProcedureOdonto procedureOdonto){
        this.id = procedureOdonto.getId();
        this.name = procedureOdonto.getName();
        this.description = procedureOdonto.getDescription();
    }
}
