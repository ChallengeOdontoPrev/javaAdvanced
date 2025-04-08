package com.odontoprev.challenge.domain;

import com.odontoprev.challenge.domain.dto.ProcedureValidationDTO;
import com.odontoprev.challenge.enums.ClassDetected;
import jakarta.persistence.*;

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

    public ProcedureValidation() {
    }

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

    public ProcedureValidation(Long id, String imgUrlInitial, String imgUrlFinal, ClassDetected classInitial, ClassDetected classFinal, Appointment appointment, ProcedureType procedureType, ProcedureStatus procedureStatus) {
        this.id = id;
        this.imgUrlInitial = imgUrlInitial;
        this.imgUrlFinal = imgUrlFinal;
        this.classInitial = classInitial;
        this.classFinal = classFinal;
        this.appointment = appointment;
        this.procedureType = procedureType;
        this.procedureStatus = procedureStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrlInitial() {
        return imgUrlInitial;
    }

    public void setImgUrlInitial(String imgUrlInitial) {
        this.imgUrlInitial = imgUrlInitial;
    }

    public String getImgUrlFinal() {
        return imgUrlFinal;
    }

    public void setImgUrlFinal(String imgUrlFinal) {
        this.imgUrlFinal = imgUrlFinal;
    }

    public ClassDetected getClassInitial() {
        return classInitial;
    }

    public void setClassInitial(ClassDetected classInitial) {
        this.classInitial = classInitial;
    }

    public ClassDetected getClassFinal() {
        return classFinal;
    }

    public void setClassFinal(ClassDetected classFinal) {
        this.classFinal = classFinal;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public ProcedureType getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(ProcedureType procedureType) {
        this.procedureType = procedureType;
    }

    public ProcedureStatus getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(ProcedureStatus procedureStatus) {
        this.procedureStatus = procedureStatus;
    }
}
