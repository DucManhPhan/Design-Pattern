package com.manhpd.unitofwork.utils.database;

import lombok.Getter;

import javax.persistence.Query;

public class QueryWrapper {

    @Getter
    private final Query query;

    public QueryWrapper(Query query) {
        this.query = query;
    }

    public QueryWrapper setParameter(String name, String value) {
        this.getQuery().setParameter(name, value);
        return this;
    }

    public void execute() {
        this.query.executeUpdate();
    }
}
