package com.manhpd;

public class Constant implements Expression {

    public final int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public <R> R acceptVisitor(Visitor<R> v) {
        return v.visitConstant(this);
    }
}
