package com.manhpd;

public class NotSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> other;

    public NotSpecification(ISpecification<T> other) {
        this.other = other;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !this.other.isSatisfiedBy(candidate);
    }
}
