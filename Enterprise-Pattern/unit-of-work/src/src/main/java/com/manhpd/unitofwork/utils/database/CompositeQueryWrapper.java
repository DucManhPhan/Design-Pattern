package com.manhpd.unitofwork.utils.database;

import lombok.Getter;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompositeQueryWrapper {

    @Getter
    private final Query query;

    public CompositeQueryWrapper(Query query) {
        this.query = query;
    }

    public CompositeQueryWrapper setParameter(String name, Object value) {
        this.getQuery().setParameter(name, value);
        return this;
    }

    public <T> List<T> getList(Function<CompositeQueryResultTuple, T> mapper) {

        return this.getTuples().stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public <T> Optional<T> getSingle(Function<CompositeQueryResultTuple, T> mapper) {
        List<CompositeQueryResultTuple> tuples = this.getTuples();
        if (tuples.size() >= 2) {
            throw new NonUniqueResultException();
        }

        return tuples.stream().findFirst().map(mapper);
    }

    public <T> T getSingleOrNull(Function<CompositeQueryResultTuple, T> mapper) {
        return this.getSingle(mapper).orElse(null);
    }

    private List<CompositeQueryResultTuple> getTuples() {
        return (List<CompositeQueryResultTuple>) this.getQuery().getResultList().stream()
                .map(obj -> new CompositeQueryResultTuple((Object[]) obj))
                .collect(Collectors.toList());
    }

}
