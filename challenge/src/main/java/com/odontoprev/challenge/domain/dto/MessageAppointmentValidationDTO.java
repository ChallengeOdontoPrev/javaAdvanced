package com.odontoprev.challenge.domain.dto;

import com.odontoprev.challenge.enums.ClassDetected;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MessageAppointmentValidationDTO {
    private Long idAppointment;
    private String imgUrlInitial;
    private String imgUrlFinal;
    private ClassDetected classInitial;
    private ClassDetected classFinal;
}
