package com.manhpd;

public class Decorator2 extends Decorator {

    public Decorator2(IComponent component) {
        super(component);
    }

    @Override
    public void doOperation() {
        this.component.doOperation();

        System.out.println("Decorator2 with new functionality.");
        this.addBehavior();
    }

    private void addBehavior() {
        System.out.println("This is new functionality with addBehavior() method.");
    }
}
