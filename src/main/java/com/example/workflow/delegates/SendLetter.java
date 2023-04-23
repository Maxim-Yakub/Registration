package com.example.workflow.delegates;

import com.example.workflow.services.alerts.RegMailSender;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class SendLetter implements JavaDelegate {

    private final RegMailSender mailSender;

    public SendLetter(RegMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String address = (String) delegateExecution.getVariable("email");

        mailSender.finishRegistration(address);
    }
}
