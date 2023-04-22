package com.example.workflow.services;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderImpl  {
    JavaMailSender mailSender;

    public MailSenderImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void finishRegistration(String email) {
        final SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom("max250996@yandex.ru");
        simpleMail.setTo(email);
        simpleMail.setSubject("Регистрация");
        simpleMail.setText("Вы успешно зарегистрировались");
        mailSender.send(simpleMail);
    }


}
