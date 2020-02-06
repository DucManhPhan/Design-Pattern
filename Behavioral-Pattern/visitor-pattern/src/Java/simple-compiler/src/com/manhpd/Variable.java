package com.manhpd;

public class Variable implements Expression {

    public final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public <R> R acceptVisitor(Visitor<R> v) {
        return v.visitVariable(this);
    }
}
