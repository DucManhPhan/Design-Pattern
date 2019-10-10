package com.manhpd.elements;

import com.manhpd.visitor.Visitor;

public class Officer implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getSalary() {
        return "Relax and high salary.";
    }
}
