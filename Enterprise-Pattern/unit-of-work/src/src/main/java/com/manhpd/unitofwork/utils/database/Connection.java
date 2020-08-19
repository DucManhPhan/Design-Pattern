package com.manhpd.unitofwork.utils.database;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import java.util.List;

public abstract class Connection {

    public abstract EntityManager getEntityManager();

    public abstract void setEntityManager(EntityManager entityManager);

    public List<?> select(final String queryString,
                          final List<QueryParameter> parameters,
                          LockModeType... lockTypeMode) {
        final Query query = getEntityManager().createQuery(queryString);
        final int parameterNumber = query.getParameters().size();
        int passParamNum;

        if (parameters == null) {
            passParamNum = 0;
        } else {
            passParamNum = parameters.size();
            parameters.stream().forEach((parameter) -> {
                query.setParameter(parameter.getParameterName(),
                                   parameter.getParameterValue());
            });
        }

        // validate parameters
        if (parameterNumber != passParamNum) {
            throw new RuntimeException("");
        }

        List<?> results;
        if (lockTypeMode.length == 0) {
            results = query.getResultList();
        } else {
            query.setLockMode(lockTypeMode[0]);
            results = query.getResultList();
        }

        return results;
    }

    public <T> T getEntityFromDatabase(Class<T> mappedEntityClass, Object primaryKeyObject) {
        return getEntityManager().find(mappedEntityClass, primaryKeyObject);
    }

    public CompositeQueryWrapper query(String queryString) {
        return new CompositeQueryWrapper(
                this.getEntityManager().createQuery(queryString));
    }

    public <T> TypedQueryWrapper<T> query(String queryString, Class<T> entityClass) {
        return new TypedQueryWrapper<>(
                this.getEntityManager().createQuery(queryString, entityClass));
    }

    public <T> TypedQueryWrapper<T> namedQuery(String queryName, Class<T> entityClass) {
        return new TypedQueryWrapper<>(
                this.getEntityManager().createNamedQuery(queryName, entityClass));
    }

}
