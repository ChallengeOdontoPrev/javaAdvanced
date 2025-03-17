package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.domain.Appointment;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppointmentDTO extends RepresentationModel<UpdateAppointmentDTO> {
    @NotNull
    private LocalDate dateAppointment;
    @NotNull
    private String timeAppointment;
    @NotNull
    private Long dentistId;
    @NotNull
    private Long procedureTypeId;

    public UpdateAppointmentDTO(Appointment appointment) {
        this.dateAppointment = appointment.getDateAppointment();
        this.timeAppointment = appointment.getTimeAppointment();
        this.dentistId = appointment.getUser().getId();
        this.procedureTypeId = appointment.getProcedureType().getId();
    }
}
