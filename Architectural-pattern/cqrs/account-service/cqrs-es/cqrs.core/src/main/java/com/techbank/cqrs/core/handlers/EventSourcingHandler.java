package com.techbank.cqrs.core.handlers;

import com.techbank.cqrs.core.domain.AggregateRoot;

public interface EventSourcingHandler<T> {
    void save(AggregateRoot aggregateRoot);

    /**
     * Return the latest state of Aggregate
     *
     * @param id
     * @return
     */
    T getById(String id);
}
