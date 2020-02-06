package com.manhpd;

public class Decorator implements IComponent {

    protected IComponent component;

    public Decorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void doOperation() {
        this.component.doOperation();
    }
}
