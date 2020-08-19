package com.manhpd.unitofwork.utils.database;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class DataConnection extends Connection implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "main")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public QueryWrapper command(String jpqlString) {
        return new QueryWrapper(this.getEntityManager().createQuery(jpqlString));
    }

    public void insertEntity(Object entity) {
        entityManager.persist(entity);
    }

    public void updateEntity(Object entity) {
        entityManager.merge(entity);
    }

    public <T> void updateWithCheck(T entity, Object primaryKey) {
        this.checkIfExists(entity.getClass(), primaryKey);
        this.updateEntity(entity);
    }

    public void removeEntityById(Class entityClass, Object primaryKey) {
        this.removeEntityFromDatabase(this.getEntityFromDatabase(entityClass, primaryKey));
    }

    /**
     * Remove entity with check existing.
     *
     * @param entityClass entity class
     * @param primaryKey  primary key
     */
    public <T> void removeWithCheck(Class<T> entityClass, Object primaryKey) {
        this.checkIfExists(entityClass, primaryKey);
        this.removeEntityById(entityClass, primaryKey);
    }

    public boolean removeEntityFromDatabase(Object entity) {
        entityManager.remove(entity);
        return true;
    }

    public int update(final String queryString, final List<QueryParameter> parameters) {
        final Query query = entityManager.createQuery(queryString);
        int result = 0;
        if (parameters != null) {
            parameters.stream().forEach(p -> query.setParameter(p.getParameterName(), p.getParameterValue()));
        }
        result = query.executeUpdate();
        return result;
    }

    public int delete(final String queryString, final List<QueryParameter> parameters) {
        return update(queryString, parameters);
    }

    public void saveListEntity(List<?> listEntities) {
        listEntities.stream().forEach((entity) -> {
            entityManager.persist(entity);
        });
    }

    private <T> void checkIfExists(Class<T> entityClass, Object primaryKey) {
        if (this.entityManager.find(entityClass, primaryKey) == null) {
            throw new NoSuchElementException();
        }
    }

}