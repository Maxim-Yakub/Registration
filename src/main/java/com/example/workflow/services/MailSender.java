package com.example.workflow.services;

public interface MailSender extends org.springframework.mail.MailSender {
    void finishRegistration(String email);
}
