package com.odontoprev.challenge.domain.dto;


import com.odontoprev.challenge.domain.ProcedureType;
import com.odontoprev.challenge.enums.ClassDetected;
import jakarta.validation.constraints.NotBlank;

public class ProcedureTypeDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private ClassDetected classInitial;
    private ClassDetected classFinal;

    public ProcedureTypeDTO(ProcedureType procedureType) {
        this.id = procedureType.getId();
        this.name = procedureType.getName();
        this.description = procedureType.getDescription();
        this.classInitial = procedureType.getClassInitial();
        this.classFinal = procedureType.getClassFinal();
    }

    public ProcedureTypeDTO() {
    }

    public ProcedureTypeDTO(Long id, String name, String description, ClassDetected classInitial, ClassDetected classFinal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classInitial = classInitial;
        this.classFinal = classFinal;
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
