package com.manhpd;

public class Decorator1 extends Decorator {

    public Decorator1(IComponent component) {
        super(component);
    }

    @Override
    public void doOperation() {
        this.component.doOperation();

        System.out.println("Decorator1 with new functionality.");
        this.addBehavior();
    }

    private void addBehavior() {
        System.out.println("This is new functionality with addBehavior() method.");
    }
}
