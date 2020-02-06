package com.manhpd;

public interface Visitor<R> {

    R visitConstant(Constant c);

    R visitVariable(Variable v);

    R visitAddition(Addition a);

}
