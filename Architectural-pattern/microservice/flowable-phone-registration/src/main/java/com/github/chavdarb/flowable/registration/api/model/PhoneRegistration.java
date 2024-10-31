package com.github.chavdarb.flowable.registration.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneRegistration implements Serializable {

    private String id;
    private String user;
    private String phoneNumber;
    private LocalDateTime creationTime;
    private long attempts;
    private List<String> activity = new ArrayList<>();

    public void initFrom(PhoneRegistrationRequest phoneRegistrationRequest) {
        this.user = phoneRegistrationRequest.getUser();
        this.phoneNumber = phoneRegistrationRequest.getPhoneNumber();
        this.creationTime = phoneRegistrationRequest.getCreationTime();
    }

}
