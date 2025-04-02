package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.ProcedureStatus;
import jakarta.validation.constraints.NotBlank;

public class ProcedureStatusDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ProcedureStatusDTO() {
    }

    public ProcedureStatusDTO(ProcedureStatus procedureStatus) {
        this.id = procedureStatus.getId();
        this.name = procedureStatus.getName();
        this.description = procedureStatus.getDescription();
    }

    public ProcedureStatusDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProcedureStatusDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
