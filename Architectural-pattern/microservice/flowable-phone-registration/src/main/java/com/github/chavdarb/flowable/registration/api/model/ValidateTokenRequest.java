package com.github.chavdarb.flowable.registration.api.model;

import lombok.Data;

@Data
public class ValidateTokenRequest {

    private String phoneNumber;
    private String token;

}
