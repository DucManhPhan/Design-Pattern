package com.manhpd;

public class OrNotSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> left;

    private ISpecification<T> right;

    public OrNotSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate)
            || !this.right.isSatisfiedBy(candidate);
    }
}
