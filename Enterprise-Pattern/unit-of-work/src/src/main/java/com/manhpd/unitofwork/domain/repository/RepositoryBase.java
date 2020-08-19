package com.manhpd.unitofwork.domain.repository;

import com.manhpd.unitofwork.utils.database.DataConnection;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RepositoryBase {

    @Autowired
    private DataConnection connection;

    protected DataConnection connection() {
        return this.connection;
    }

}
