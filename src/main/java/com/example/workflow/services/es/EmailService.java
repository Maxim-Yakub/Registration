package com.example.workflow.services.es;

import com.example.workflow.models.Email;

public interface EmailService {
    void createEmailIndex(final Email email);

    Email findByDomain(String domain);
}
