package com.manhpd;

public class PrettyPrinting implements Visitor<Void> {

    private StringBuffer sb = new StringBuffer();

    public static String of(Expression e) {
        PrettyPrinting pp = new PrettyPrinting();
        e.acceptVisitor(pp);
        return pp.sb.toString();
    }

    @Override
    public Void visitConstant(Constant c) {
        sb.append(c.value);
        return null;
    }

    @Override
    public Void visitVariable(Variable v) {
        sb.append(v.name);
        return null;
    }

    @Override
    public Void visitAddition(Addition add) {
        sb.append('(');
        add.left.acceptVisitor(this);
        sb.append(" + ");
        add.right.acceptVisitor(this);
        sb.append(')');
        return null;
    }
}
