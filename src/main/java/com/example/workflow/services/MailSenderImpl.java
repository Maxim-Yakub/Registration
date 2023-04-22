package com.example.workflow.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSenderImpl implements RegMailSender {
    MailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public MailSenderImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void finishRegistration(String email) {
        final SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(username);
        simpleMail.setTo(email);
        simpleMail.setSubject("Регистрация");
        simpleMail.setText("Вы успешно зарегистрировались");
        mailSender.send(simpleMail);
    }


}
