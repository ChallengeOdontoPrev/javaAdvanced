package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.ProcedureStatusDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_procedure_status")
public class ProcedureStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "procedureStatus")
    private List<ProcedureValidation> procedureValidations;

    public ProcedureStatus(ProcedureStatusDTO procedureStatusDTO) {
        this.id = procedureStatusDTO.getId();
        this.name = procedureStatusDTO.getName();
        this.description = procedureStatusDTO.getDescription();
    }

    public ProcedureStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
