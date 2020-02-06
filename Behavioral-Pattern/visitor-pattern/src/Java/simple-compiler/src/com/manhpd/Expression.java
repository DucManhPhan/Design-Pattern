package com.manhpd;

public interface Expression {

    <R> R acceptVisitor(Visitor<R> v);

}
