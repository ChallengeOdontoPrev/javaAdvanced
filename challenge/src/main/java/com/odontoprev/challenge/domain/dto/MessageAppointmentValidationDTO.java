package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.enums.ClassDetected;

import java.util.Objects;

public class MessageAppointmentValidationDTO {
    private Long idAppointment;
    private String imgUrlInitial;
    private String imgUrlFinal;
    private ClassDetected classInitial;
    private ClassDetected classFinal;

    public MessageAppointmentValidationDTO() {
    }

    public MessageAppointmentValidationDTO(Long idAppointment, String imgUrlInitial, String imgUrlFinal, ClassDetected classInitial, ClassDetected classFinal) {
        this.idAppointment = idAppointment;
        this.imgUrlInitial = imgUrlInitial;
        this.imgUrlFinal = imgUrlFinal;
        this.classInitial = classInitial;
        this.classFinal = classFinal;
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MessageAppointmentValidationDTO that = (MessageAppointmentValidationDTO) o;
        return Objects.equals(idAppointment, that.idAppointment) && Objects.equals(imgUrlInitial, that.imgUrlInitial) && Objects.equals(imgUrlFinal, that.imgUrlFinal) && classInitial == that.classInitial && classFinal == that.classFinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAppointment, imgUrlInitial, imgUrlFinal, classInitial, classFinal);
    }
}
