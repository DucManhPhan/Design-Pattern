package com.manhpd;

public abstract class CompositeSpecification<T> implements ISpecification<T> {

    public abstract boolean isSatisfiedBy(T candidate);

    public ISpecification<T> and(ISpecification<T> other) {
        return new AndSpecification<T>(this, other);
    }

    public ISpecification<T> andNot(ISpecification<T> other) {
        return new AndNotSpecification<T>(this, other);
    }

    public ISpecification<T> or(ISpecification<T> other) {
        return new OrSpecification<T>(this, other);
    }

    public ISpecification<T> orNot(ISpecification<T> other) {
        return new OrNotSpecification<T>(this, other);
    }

    public ISpecification<T> not(ISpecification<T> other) {
        return new NotSpecification<T>(other);
    }

}
