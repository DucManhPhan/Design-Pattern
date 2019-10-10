package com.manhpd.elements;

import com.manhpd.visitor.Visitor;

public class Employee implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getWorkingTime() {
        return "Employee usually works for more than 8 hours";
    }
}
