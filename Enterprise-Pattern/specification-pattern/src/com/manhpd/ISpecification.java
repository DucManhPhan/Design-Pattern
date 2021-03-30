package com.manhpd;

public interface ISpecification<T> {

    boolean isSatisfiedBy(T candidate);

    ISpecification<T> and(ISpecification<T> other);

    ISpecification<T> andNot(ISpecification<T> other);

    ISpecification<T> or(ISpecification<T> other);

    ISpecification<T> orNot(ISpecification<T> other);

    ISpecification<T> not(ISpecification<T> other);
}
