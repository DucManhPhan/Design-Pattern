package com.manhpd;

public class ClassAdapter extends Adaptee implements ITarget {

    @Override
    public String operation() {
        return this.specificOperation();
    }
}
