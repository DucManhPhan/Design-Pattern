package com.github.chavdarb.flowable.registration.api.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PhoneRegistrationRequest implements Serializable {

    private String user;
    private String phoneNumber;
    private LocalDateTime creationTime;

}
