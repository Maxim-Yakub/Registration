package com.example.workflow;

import com.example.workflow.services.MailSender;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class SendLetter implements JavaDelegate {

    MailSender mailSender;

    public SendLetter(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String address = (String) delegateExecution.getVariable("email");

        mailSender.finishRegistration(address);

        System.out.println(address);
    }
}
