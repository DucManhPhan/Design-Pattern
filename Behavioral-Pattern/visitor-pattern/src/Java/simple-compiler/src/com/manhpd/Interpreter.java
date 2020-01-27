package com.manhpd;

import java.util.Map;

public class Interpreter implements Visitor<Integer> {

    private final Map<String, Integer> env;
    private Interpreter(Map<String, Integer> env) { this.env = env; }

    public static int eval(Expression e, Map<String, Integer> env) {
        return e.acceptVisitor(new Interpreter(env));
    }

    @Override
    public Integer visitConstant(Constant c) {
        return c.value;
    }

    @Override
    public Integer visitVariable(Variable v) {
        return env.get(v.name);
    }

    @Override
    public Integer visitAddition(Addition add) {
        return add.left.acceptVisitor(this) + add.right.acceptVisitor(this);
    }
}
