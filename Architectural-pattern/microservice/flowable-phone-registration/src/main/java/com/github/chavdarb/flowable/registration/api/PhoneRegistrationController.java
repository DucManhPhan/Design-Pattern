package com.github.chavdarb.flowable.registration.api;

import com.github.chavdarb.flowable.registration.api.model.CreateTokenRequest;
import com.github.chavdarb.flowable.registration.api.model.CreateTokenResponse;
import com.github.chavdarb.flowable.registration.api.model.PhoneRegistration;
import com.github.chavdarb.flowable.registration.api.model.PhoneRegistrationRequest;
import com.github.chavdarb.flowable.registration.api.model.ValidateTokenRequest;
import com.github.chavdarb.flowable.registration.api.model.ValidateTokenResponse;
import com.github.chavdarb.flowable.registration.service.PhoneRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/user/phone/registration", produces = "application/json")
@Slf4j
public class PhoneRegistrationController {

    PhoneRegistrationService phoneRegistrationService;

    public PhoneRegistrationController(PhoneRegistrationService phoneRegistrationService) {
        this.phoneRegistrationService = phoneRegistrationService;
    }

    @PostMapping(value = "/{userId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneRegistration createPhohoneRegistration(@PathVariable("userId") String userId, @RequestBody PhoneRegistrationRequest phoneRegistrationRequest) {
        log.info("Created PhoneRegistration process instance for user {} and phone {}.", userId, phoneRegistrationRequest.getPhoneNumber());
        phoneRegistrationRequest.setUser(userId);
        phoneRegistrationRequest.setCreationTime(LocalDateTime.now());
        return phoneRegistrationService.createPhoneRegistrationRequest(phoneRegistrationRequest);
    }

    @GetMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<PhoneRegistration> getPhohoneRegistrations(@PathVariable("userId") String userId) {
        log.info("Gets PhoneRegistration process instances for user {}.", userId);
        return phoneRegistrationService.getPhoneRegistrationRequests(userId);
    }

    @PostMapping(value = "/{userId}/{registrationId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTokenResponse createToken(@PathVariable("userId") String userId, @PathVariable("registrationId") String registrationId,
            @RequestBody CreateTokenRequest tokenRequest) {
        log.info("Sending SMS token to {} on Phone {}.", userId, tokenRequest.getPhoneNumber());
        return phoneRegistrationService.triggerTokenSend(userId, registrationId, tokenRequest);
    }

    @PostMapping(value = "/{userId}/{registrationId}/token")
    @ResponseStatus(HttpStatus.OK)
    public ValidateTokenResponse validateToken(@PathVariable("userId") String userId, @PathVariable("registrationId") String registrationId,
            @RequestBody ValidateTokenRequest token) {
        return phoneRegistrationService.validateToken(userId, registrationId, token);
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void invalidInput() {
        // Do custom handling required
    }

    @ExceptionHandler({ UnsupportedOperationException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void notFound() {
        // Do custom handling required
    }
}
