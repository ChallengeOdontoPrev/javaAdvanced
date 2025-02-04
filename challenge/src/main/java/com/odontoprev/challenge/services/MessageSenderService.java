package com.odontoprev.challenge.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odontoprev.challenge.domain.Appointment;
import com.odontoprev.challenge.domain.dto.MessageAppointmentValidationDTO;
import com.odontoprev.challenge.gateway.PubsubOutboundGateway;
import com.odontoprev.challenge.services.exceptions.JsonConvertException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSenderService {

    private final ObjectMapper objectMapper;

    private final PubsubOutboundGateway messagingGateway;


    public String processAndSendMessage(Appointment appointment, String imgUrlInitial, String imgUrlFinal) {

        MessageAppointmentValidationDTO message = new MessageAppointmentValidationDTO(
                appointment.getId(),
                imgUrlInitial,
                imgUrlFinal,
                appointment.getProcedureValidation().getClassInitial(),
                appointment.getProcedureValidation().getClassFinal()
        );

        try {
            String messageJson = writeValueAsString(message);
            sendToPubsub(messageJson);

            return messageJson;

        } catch (JsonProcessingException e) {
            throw new JsonConvertException(e.getMessage());
        }
    }

    public String writeValueAsString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public void sendToPubsub(String messageJson) {
        messagingGateway.sendToPubsub(messageJson);
    }
}
