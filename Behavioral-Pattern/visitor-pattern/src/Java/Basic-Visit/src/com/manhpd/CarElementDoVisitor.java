package com.manhpd;

public class CarElementDoVisitor implements CarElementVisitor {

    @Override
    public void visit(Body body) {
        System.out.println("Moving my body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Starting my car");
        CarElement[] elements = car.getElements();
        for (final CarElement element : elements) {
            element.accept(this);
        }

        System.out.println("Started my car");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }
}
