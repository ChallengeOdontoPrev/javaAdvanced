package com.challenge.odonto_prev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Envia um e-mail simples
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admOdontoPrev@odontoprev.com.br");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    // Método específico para enviar o e-mail de redefinição de senha
    public void sendPasswordResetEmail(String to, String resetUrl) {
        String subject = "Redefinição de Senha";
        String text = "Olá,\n\n" +
                      "Recebemos uma solicitação para redefinir sua senha. " +
                      "Clique no link abaixo para redefinir sua senha:\n" +
                      resetUrl + "\n\n" +
                      "Se você não solicitou essa alteração, ignore este e-mail.\n\n" +
                      "Atenciosamente,\n" +
                      "Equipe OdontoPrev";
        sendSimpleMessage(to, subject, text);
    }
}

