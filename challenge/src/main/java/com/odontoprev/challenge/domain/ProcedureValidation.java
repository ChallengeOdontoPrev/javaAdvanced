package com.odontoprev.challenge.domain;

import com.odontoprev.challenge.domain.dto.ProcedureValidationDTO;
import com.odontoprev.challenge.enums.ClassDetected;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_procedure_validation")
public class ProcedureValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgUrlInitial;
    private String imgUrlFinal;

    @Enumerated(EnumType.STRING)
    private ClassDetected classInitial;
    @Enumerated(EnumType.STRING)
    private ClassDetected classFinal;

    @OneToOne(mappedBy = "procedureValidation")
    private Appointment appointment;
    @ManyToOne
    private ProcedureType procedureType;
    @ManyToOne
    private ProcedureStatus procedureStatus;

    public ProcedureValidation(ProcedureValidationDTO procedureValidationDTO) {
        this.id = procedureValidationDTO.getId();
        this.imgUrlInitial = procedureValidationDTO.getImgUrlInitial();
        this.imgUrlFinal = procedureValidationDTO.getImgUrlFinal();
        this.classInitial = procedureValidationDTO.getClassInitial();
        this.classFinal = procedureValidationDTO.getClassFinal();
    }

    public ProcedureValidation(ProcedureValidation procedureValidation) {
        this.id = procedureValidation.getId();
        this.imgUrlInitial = procedureValidation.getImgUrlInitial();
        this.imgUrlFinal = procedureValidation.getImgUrlFinal();
        this.appointment = procedureValidation.getAppointment();
        this.procedureType = procedureValidation.getProcedureType();
        this.procedureStatus = procedureValidation.getProcedureStatus();
        this.classInitial = procedureValidation.getClassInitial();
        this.classFinal = procedureValidation.getClassFinal();
    }
}
