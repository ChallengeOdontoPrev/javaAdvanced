package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.ProcedureOdontoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_procedure_odonto")
public class ProcedureOdonto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

    public ProcedureOdonto(ProcedureOdontoDTO procedureOdontoDTO){
        this.id = procedureOdontoDTO.getId();
        this.name = procedureOdontoDTO.getName();
        this.description = procedureOdontoDTO.getDescription();
    }

}
