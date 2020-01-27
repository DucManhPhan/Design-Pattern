package com.manhpd;

public class ConstantFolding implements Visitor<Expression> {

    @Override
    public Expression visitConstant(Constant c) {
        return c;
    }

    @Override
    public Expression visitVariable(Variable v) {
        return v;
    }

    @Override
    public Expression visitAddition(Addition add) {
        Expression left = add.left.acceptVisitor(this);
        Expression right = add.right.acceptVisitor(this);

        if (left instanceof Constant && right instanceof Constant) {
            int leftValue = ((Constant) left).value;
            int rightValue = ((Constant) right).value;
            return new Constant(leftValue + rightValue);
        }

        return new Addition(left, right);
    }
}
