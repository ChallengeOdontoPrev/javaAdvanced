package com.odontoprev.challenge.services;


import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.odontoprev.challenge.domain.Appointment;
import com.odontoprev.challenge.domain.dto.MessageAppointmentValidationDTO;
import com.odontoprev.challenge.services.exceptions.JsonConvertException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    private final ObjectMapper objectMapper;

    @Value("${azure.connection-bus-send}")
    private String connectionBusSend;

    @Value("${azure.queue-name}")
    private String queueName;

    public MessageSenderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

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
            sendToAzureBus(messageJson);

            return messageJson;

        } catch (JsonProcessingException e) {
            throw new JsonConvertException(e.getMessage());
        }
    }

    public void sendToAzureBus(String messageJson) {
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .connectionString(connectionBusSend)
                .sender()
                .queueName(queueName)
                .buildClient();

        senderClient.sendMessage(new ServiceBusMessage(messageJson));
    }

    public String writeValueAsString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

}
