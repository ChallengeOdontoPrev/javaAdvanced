package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.ProcedureValidation;
import com.odontoprev.challenge.enums.ClassDetected;

public class ProcedureValidationDTO {
    private Long id;
    private String imgUrlInitial;
    private String imgUrlFinal;
    private ProcedureTypeDTO procedureType;
    private ProcedureStatusDTO procedureStatus;
    private ClassDetected classInitial;
    private ClassDetected classFinal;

    public ProcedureValidationDTO(ProcedureValidation procedureValidation) {
        this.id = procedureValidation.getId();
        this.imgUrlInitial = procedureValidation.getImgUrlInitial();
        this.imgUrlFinal = procedureValidation.getImgUrlFinal();
        this.procedureType = new ProcedureTypeDTO(procedureValidation.getProcedureType());
        this.procedureStatus = new ProcedureStatusDTO(procedureValidation.getProcedureStatus());
        this.classInitial = procedureValidation.getClassInitial();
        this.classFinal = procedureValidation.getClassFinal();
    }

    public ProcedureValidationDTO() {
    }

    public ProcedureValidationDTO(Long id, String imgUrlInitial, String imgUrlFinal, ProcedureTypeDTO procedureType, ProcedureStatusDTO procedureStatus, ClassDetected classInitial, ClassDetected classFinal) {
        this.id = id;
        this.imgUrlInitial = imgUrlInitial;
        this.imgUrlFinal = imgUrlFinal;
        this.procedureType = procedureType;
        this.procedureStatus = procedureStatus;
        this.classInitial = classInitial;
        this.classFinal = classFinal;
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

    public ProcedureTypeDTO getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(ProcedureTypeDTO procedureType) {
        this.procedureType = procedureType;
    }

    public ProcedureStatusDTO getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(ProcedureStatusDTO procedureStatus) {
        this.procedureStatus = procedureStatus;
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
}
