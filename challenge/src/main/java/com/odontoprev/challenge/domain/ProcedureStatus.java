package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.ProcedureStatusDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
