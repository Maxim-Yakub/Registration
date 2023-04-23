package com.example.workflow.delegates;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;

import javax.inject.Named;

@Named
public class SaveRegistrationInfo implements JavaDelegate {
        @Override
        public void execute(DelegateExecution delegateExecution) throws Exception {

                IdentityService identityService = delegateExecution.getProcessEngine().getIdentityService();

                if(identityService.isReadOnly()) {
                        return;
                }

                String id = (String) delegateExecution.getVariable("id");

                User singleResult = identityService.createUserQuery().userId(id).singleResult();
                if (singleResult != null) {
                        return;
                }

                User user = identityService.newUser((String) delegateExecution.getVariable("id"));
                user.setFirstName((String) delegateExecution.getVariable("firstname"));
                user.setLastName((String) delegateExecution.getVariable("lastname"));
                user.setPassword((String) delegateExecution.getVariable("password"));
                user.setEmail((String) delegateExecution.getVariable("email"));

                identityService.saveUser(user);
        }
}
