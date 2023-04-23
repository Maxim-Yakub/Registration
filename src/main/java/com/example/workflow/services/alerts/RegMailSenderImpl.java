package com.example.workflow.services.alerts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegMailSenderImpl implements RegMailSender {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;
    public RegMailSenderImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void finishRegistration(String email) {

        final SimpleMailMessage simpleMail = new SimpleMailMessage();

        simpleMail.setFrom(sender);
        simpleMail.setTo(email);
        simpleMail.setSubject("Регистрация");
        simpleMail.setText("Вы успешно зарегистрировались");

        mailSender.send(simpleMail);
    }
}
