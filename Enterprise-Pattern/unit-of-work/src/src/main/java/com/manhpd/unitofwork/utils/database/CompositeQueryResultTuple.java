package com.manhpd.unitofwork.utils.database;

import java.util.Arrays;
import java.util.List;

public class CompositeQueryResultTuple {

    private final List<Object> entities;

    public CompositeQueryResultTuple(Object[] entities) {
        this.entities = Arrays.asList(entities);
    }

    public <T> T get(Class<T> target) {
        return (T) this.entities.stream()
                .filter(e -> e.getClass().equals(target))
                .findFirst()
                .get();
    }

}
