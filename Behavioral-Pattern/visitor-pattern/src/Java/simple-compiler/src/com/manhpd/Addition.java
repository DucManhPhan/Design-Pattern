package com.manhpd;

public class Addition implements Expression {

    public final Expression left;

    public final Expression right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <R> R acceptVisitor(Visitor<R> v) {
        return v.visitAddition(this);
    }
}
