package com.manhpd.unitofwork.utils.database;

import lombok.Getter;

import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TypedQueryWrapper<T> {

    @Getter
    private final TypedQuery<T> query;

    public TypedQueryWrapper(TypedQuery<T> typedQuery) {
        this.query = typedQuery;
    }

    public TypedQueryWrapper<T> setParameter(String name, Object value) {
        this.getQuery().setParameter(name, value);
        return this;
    }

    public TypedQueryWrapper<T> setQueryOption(Consumer<TypedQuery<T>> setter) {
        setter.accept(this.query);
        return this;
    }

    public List<T> getList() {
        return this.getQuery().getResultList();
    }

    /**
     * Get result as list with mapping.
     * @param mapper mapper
     * @return result
     */
    public <D> List<D> getList(Function<T, D> mapper) {
        return this.getList().stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * Get result as optional.
     *
     * @return result
     */
    public Optional<T> getSingle() {
        List<T> results = this.getQuery().getResultList();

        if (results.size() >= 2) {
            throw new NonUniqueResultException();
        }

        if (results.size() == 0) {
            return Optional.empty();
        }

        return Optional.ofNullable(results.get(0));
    }

    /**
     * Get result as optional with mapping.
     *
     * @param mapper mapper
     * @return result
     */
    public <D> Optional<D> getSingle(Function<T, D> mapper) {
        return this.getSingle().map(mapper);
    }

    /**
     * Get single result, or null if not exists.
     *
     * @return result
     */
    public T getSingleOrNull() {
        return this.getSingle().orElse(null);
    }

    /**
     * Get single result with mapping, or null.
     *
     * @param mapper mapper
     * @return result
     */
    public <D> D getSingleOrNull(Function<T, D> mapper) {
        return this.getSingle(mapper).orElse(null);
    }

    /**
     * Get single result with mapping, or default data.
     *
     * @param isDefault check if is default data entity
     * @param mapper mapper
     * @return result
     */
    protected <D> D getSingleOrDefault(Predicate<T> isDefault, Function<T, D> mapper) {
        List<T> results = this.getList();

        if (results.size() >= 3) {
            throw new NonUniqueResultException();
        }

        T entity = results.stream()
                .filter(e -> !isDefault.test(e))
                .findFirst()
                .orElseGet(() -> {
                    return results.stream().filter(isDefault).findFirst()
                            .orElseThrow(() -> new RuntimeException("default data is not found."));
                });

        return mapper.apply(entity);
    }

}
