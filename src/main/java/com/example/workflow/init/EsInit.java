package com.example.workflow.init;

import com.example.workflow.models.Email;
import com.example.workflow.services.es.EmailService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EsInit {

    EmailService emailService;

    public EsInit(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostConstruct
    public void addEmails() {
        emailService.createEmailIndex(new Email("yandex.ru"));
        emailService.createEmailIndex(new Email("gmail.com"));
        emailService.createEmailIndex(new Email("mail.ru"));
        emailService.createEmailIndex(new Email("ya.ru"));
    }
}
