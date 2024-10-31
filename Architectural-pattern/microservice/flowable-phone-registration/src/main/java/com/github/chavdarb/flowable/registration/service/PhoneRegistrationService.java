package com.github.chavdarb.flowable.registration.service;

import com.github.chavdarb.flowable.registration.api.model.CreateTokenRequest;
import com.github.chavdarb.flowable.registration.api.model.CreateTokenResponse;
import com.github.chavdarb.flowable.registration.api.model.PhoneRegistration;
import com.github.chavdarb.flowable.registration.api.model.PhoneRegistrationRequest;
import com.github.chavdarb.flowable.registration.api.model.Token;
import com.github.chavdarb.flowable.registration.api.model.ValidateTokenRequest;
import com.github.chavdarb.flowable.registration.api.model.ValidateTokenResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.IdentityService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.chavdarb.flowable.registration.process.tasks.context.ContextVariables.*;

@Service
@Slf4j
@AllArgsConstructor
public class PhoneRegistrationService {

    RuntimeService runtimeService;
    TaskService taskService;
    IdentityService identityService;

    /**
     * Instantiate PhoneRegistrationRequest process.
     *
     * @param phoneRegistrationRequest
     * @return
     */
    public PhoneRegistration createPhoneRegistrationRequest(PhoneRegistrationRequest phoneRegistrationRequest) {
        // Init process input variables
        PhoneRegistration phoneRegistration = new PhoneRegistration();
        phoneRegistration.initFrom(phoneRegistrationRequest);
        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put(PHONE_REGISTRATION_VARIABLE, phoneRegistration);

        // Start the process
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey(PROCESS_NAME, phoneRegistrationRequest.getUser(), processVariables);

        // Init response with process instance id
        phoneRegistration.setId(processInstance.getProcessInstanceId());
        return phoneRegistration;
    }

    /**
     * Returns ongoing PhoneRegistrationRequests.
     *
     * @param userId
     * @return
     */
    public List<PhoneRegistration> getPhoneRegistrationRequests(String userId) {
        // Get ongoing Process Instances for this User
        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(PROCESS_NAME)
                .processInstanceBusinessKey(userId)
                .includeProcessVariables()
                .list();

        // Collect Details of each process status
        List<PhoneRegistration> phoneRegistrations = new ArrayList<>();
        for (ProcessInstance processInstance : processInstanceList) {
            PhoneRegistration phoneRegistration = (PhoneRegistration) processInstance.getProcessVariables().get(PHONE_REGISTRATION_VARIABLE);
            phoneRegistration.setId(processInstance.getProcessInstanceId());

            // Demo showing current process state
            List<Execution> executionList = runtimeService.createExecutionQuery()
                    .processInstanceId(processInstance.getProcessInstanceId())
                    .list();
            for (Execution execution : executionList) {
                if (execution.getActivityId() != null) {
                    phoneRegistration.getActivity().add(execution.getActivityId());
                }
            }

            phoneRegistrations.add(phoneRegistration);
        }

        return phoneRegistrations;
    }

    /**
     * Trigger generation of new token (invalidating the old one).
     *
     * @param userId
     * @param processInstanceId
     * @param tokenRequest
     * @return
     */
    public CreateTokenResponse triggerTokenSend(String userId, String processInstanceId, CreateTokenRequest tokenRequest) {
        // Get new Token creation task.
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_NAME)
                .processInstanceBusinessKey(userId)
                .processInstanceId(processInstanceId)
                .taskDefinitionKey("triggerNewTokenSend")
                .active()
                .singleResult();

        if (task == null) {
            throw new UnsupportedOperationException("Registration not found.");
        }

        // Get Task Input variable and compare phone number
        PhoneRegistration phoneRegistration = taskService.getVariable(task.getId(), PHONE_REGISTRATION_VARIABLE, PhoneRegistration.class);
        if (!phoneRegistration.getPhoneNumber().equals(tokenRequest.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number.");
        }

        // Complete Generate new Token task.
        log.info("Generating new token for registration {}.", processInstanceId);
        taskService.complete(task.getId(), null);

        // Return response
        CreateTokenResponse tokenResponse = new CreateTokenResponse();
        tokenResponse.setId(processInstanceId);
        tokenResponse.setPhoneNumber(tokenRequest.getPhoneNumber());
        tokenResponse.setUser(userId);
        tokenResponse.setAttemptsLeft(MAX_ATTEMPTS - phoneRegistration.getAttempts() - 1);
        return tokenResponse;
    }

    public ValidateTokenResponse validateToken(String userId, String processInstanceId, ValidateTokenRequest token) {
        ValidateTokenResponse response = new ValidateTokenResponse();
        response.setPhone(token.getPhoneNumber());
        response.setStatus(ValidateTokenResponse.ValidationStatus.INVALID);

        // Get new Token input task.
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_NAME)
                .processInstanceBusinessKey(userId)
                .processInstanceId(processInstanceId)
                .taskDefinitionKey("inputToken")
                .active()
                .singleResult();

        if (task == null) {
            throw new UnsupportedOperationException("Registration not found.");
        }

        // Get Task Input variable and compare phone number
        PhoneRegistration phoneRegistration = taskService.getVariable(task.getId(), PHONE_REGISTRATION_VARIABLE, PhoneRegistration.class);
        if (!phoneRegistration.getPhoneNumber().equals(token.getPhoneNumber())) {
            return response;
        }

        // Get Token from context and validate
        Token realToken = taskService.getVariable(task.getId(), TOKEN_VARIABLE, Token.class);

        if (realToken != null && realToken.getValue().equals(token.getToken())) {
            LocalDateTime expirationTime = realToken.getCreationTime().plusSeconds(realToken.getDuration());
            if (LocalDateTime.now().isBefore(expirationTime)) {
                // Token is valid so complete the task
                log.info("Input token matches token with Id {}. Completing the registration process.", realToken.getId());
                taskService.complete(task.getId(), null);
                response.setStatus(ValidateTokenResponse.ValidationStatus.VALID);
            }
        }
        return response;
    }

}
