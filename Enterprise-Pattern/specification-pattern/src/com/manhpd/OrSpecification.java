package com.manhpd;

public class OrSpecification<T> extends CompositeSpecification<T> {

    private ISpecification<T> left;

    private ISpecification<T> right;

    public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate)
            || this.right.isSatisfiedBy(candidate);
    }
}
