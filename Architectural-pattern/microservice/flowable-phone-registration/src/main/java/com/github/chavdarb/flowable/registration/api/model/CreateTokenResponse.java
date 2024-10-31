package com.github.chavdarb.flowable.registration.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTokenResponse implements Serializable {

    private String id;
    private String user;
    private String phoneNumber;
    private long attemptsLeft;

}
