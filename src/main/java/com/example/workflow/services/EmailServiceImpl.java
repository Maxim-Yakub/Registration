package com.example.workflow.services;

import com.example.workflow.models.Email;
import com.example.workflow.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void createEmailIndex(Email email) {
        emailRepository.save(email);
    }

    @Override
    public Email findByDomain(String domain) {

        return emailRepository.findByDomain(domain);
    }
}
