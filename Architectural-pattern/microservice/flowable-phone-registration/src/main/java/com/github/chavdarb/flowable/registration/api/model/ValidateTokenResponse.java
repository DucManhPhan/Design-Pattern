package com.github.chavdarb.flowable.registration.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidateTokenResponse {

    public enum ValidationStatus {
        VALID,
        INVALID
    }

    private String phone;
    private ValidationStatus status;

}
