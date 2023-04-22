package com.example.workflow;

import com.example.workflow.models.Email;
import com.example.workflow.services.EmailService;
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
//        String domain = (String) delegateExecution.getVariable("email");
       String domain = "gmail.com";
        Optional<Email> emailOptional = Optional.ofNullable(emailService.findByDomain(domain));
        if(emailOptional.isEmpty()) {
            check = "not success";
        }
        delegateExecution.setVariable("check", check);

//        System.out.println(email.getDomain());
    }
}
