package com.github.chavdarb.flowable.registration.process.tasks;

import com.github.chavdarb.flowable.registration.api.model.PhoneRegistration;
import com.github.chavdarb.flowable.registration.process.tasks.context.ContextVariables;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SetPhoneStatusTask implements JavaDelegate {

    @Override public void execute(DelegateExecution execution) {
        PhoneRegistration phoneRegistration = execution.getVariable(ContextVariables.PHONE_REGISTRATION_VARIABLE, PhoneRegistration.class);
        log.info("Updating Phone Contact of User {} to {}", phoneRegistration.getUser(), phoneRegistration.getPhoneNumber());
    }

}
