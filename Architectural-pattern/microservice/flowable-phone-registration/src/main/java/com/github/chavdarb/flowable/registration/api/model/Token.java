package com.github.chavdarb.flowable.registration.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Token implements Serializable {

    private String id;
    private String value;
    private LocalDateTime creationTime;
    // Defaults to 60 seconds
    private long duration = 60;

}
