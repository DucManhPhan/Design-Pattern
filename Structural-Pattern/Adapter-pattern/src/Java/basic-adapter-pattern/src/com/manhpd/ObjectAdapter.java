package com.manhpd;

public class ObjectAdapter implements ITarget {

    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String operation() {
        return this.adaptee.specificOperation();
    }
}
