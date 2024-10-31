package com.github.chavdarb.flowable.registration.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateTokenRequest implements Serializable {

    private String phoneNumber;

}
