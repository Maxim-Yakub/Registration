package com.example.workflow.delegates;

import com.example.workflow.models.Email;
import com.example.workflow.services.es.EmailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.Optional;

@Named
public class CheckDomain implements JavaDelegate {

    EmailService emailService;

    public CheckDomain(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String check = "success";

        String email = (String) delegateExecution.getVariable("email");

        String[] emailParts = email.split("@");

        Optional<Email> emailOptional = Optional.ofNullable(emailService.findByDomain(emailParts[1]));

        if(emailOptional.isEmpty()) {

            check = "not success";
        }

        delegateExecution.setVariable("check", check);
    }
}
