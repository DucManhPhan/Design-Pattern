package com.github.chavdarb.flowable.registration.process.tasks;

import com.github.chavdarb.flowable.registration.api.model.PhoneRegistration;
import com.github.chavdarb.flowable.registration.api.model.Token;
import com.github.chavdarb.flowable.registration.process.tasks.context.ContextVariables;
import com.github.chavdarb.flowable.registration.service.TokenGeneratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Sens SMS Token using external infrastructure.
 */
@Component
@Slf4j
@AllArgsConstructor
public class SendTokenTask implements JavaDelegate {

    private TokenGeneratorService tokenGeneratorService;

    @Override public void execute(DelegateExecution execution) {
        // Generate new Token
        Token token = tokenGeneratorService.generateToken();
        execution.setVariable(ContextVariables.TOKEN_VARIABLE, token);

        // Send Token to client (mail,sms,...)
        PhoneRegistration phoneRegistration = execution.getVariable(ContextVariables.PHONE_REGISTRATION_VARIABLE, PhoneRegistration.class);
        log.info("Sending new Token {} to {}", token, phoneRegistration.getUser());

        // Increase token attempts
        phoneRegistration.setAttempts(phoneRegistration.getAttempts() + 1);
        execution.setVariable(ContextVariables.PHONE_REGISTRATION_VARIABLE, phoneRegistration);
    }

}
