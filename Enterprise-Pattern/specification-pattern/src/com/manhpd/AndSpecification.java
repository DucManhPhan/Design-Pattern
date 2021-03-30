package com.manhpd;

public class AndSpecification<T> extends CompositeSpecification<T>  {

    private ISpecification<T> left;

    private ISpecification<T> right;

    public AndSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate)
            && this.right.isSatisfiedBy(candidate);
    }
}
