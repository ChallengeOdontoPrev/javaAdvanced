package com.challenge.odonto_prev.domain;

import com.challenge.odonto_prev.domain.dto.ProcedureValidationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_procedure_validation")
public class ProcedureValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgUrlInitial;
    private String imgUrlFinal;

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
    }

    public ProcedureValidation(ProcedureValidation procedureValidation) {
        this.id = procedureValidation.getId();
        this.imgUrlInitial = procedureValidation.getImgUrlInitial();
        this.imgUrlFinal = procedureValidation.getImgUrlFinal();
        this.appointment = procedureValidation.getAppointment();
        this.procedureType = procedureValidation.getProcedureType();
        this.procedureStatus = procedureValidation.getProcedureStatus();
    }
}
