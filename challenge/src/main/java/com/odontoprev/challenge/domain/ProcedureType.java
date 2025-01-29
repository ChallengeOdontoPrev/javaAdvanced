package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.ProcedureTypeDTO;
import com.odontoprev.challenge.enums.ClassDetected;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_procedure_type")
public class ProcedureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ClassDetected classInitial;
    @Enumerated(EnumType.STRING)
    private ClassDetected classFinal;

    @OneToMany(mappedBy = "procedureType")
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "procedureType")
    private List<ProcedureValidation> procedureValidations;

    public ProcedureType(ProcedureTypeDTO procedureTypeDTO) {
        this.id = procedureTypeDTO.getId();
        this.name = procedureTypeDTO.getName();
        this.description = procedureTypeDTO.getDescription();
        this.classInitial = procedureTypeDTO.getClassInitial();
        this.classFinal = procedureTypeDTO.getClassFinal();
    }
}
