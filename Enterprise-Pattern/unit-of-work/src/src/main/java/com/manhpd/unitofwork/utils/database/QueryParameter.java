package com.manhpd.unitofwork.utils.database;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueryParameter {

    private String parameterName;

    private Object parameterValue;

}
