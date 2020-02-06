package com.manhpd;

public class Wheel implements CarElement {

    private String name;

    public Wheel(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void accept(final CarElementVisitor visitor) {
        visitor.visit(this);
    }

}
