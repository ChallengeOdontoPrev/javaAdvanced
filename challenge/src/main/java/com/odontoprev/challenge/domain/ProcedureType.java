package com.odontoprev.challenge.domain;


import com.odontoprev.challenge.domain.dto.ProcedureTypeDTO;
import com.odontoprev.challenge.enums.ClassDetected;
import jakarta.persistence.*;

import java.util.List;

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

    public ProcedureType() {
    }

    public ProcedureType(Long id, String name, String description, ClassDetected classInitial, ClassDetected classFinal, List<Appointment> appointments, List<ProcedureValidation> procedureValidations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classInitial = classInitial;
        this.classFinal = classFinal;
        this.appointments = appointments;
        this.procedureValidations = procedureValidations;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<ProcedureValidation> getProcedureValidations() {
        return procedureValidations;
    }

    public void setProcedureValidations(List<ProcedureValidation> procedureValidations) {
        this.procedureValidations = procedureValidations;
    }
}
