package com.manhpd;

/**
 * Object structure in UML diagram
 *
 */
public class Car implements CarElement {

    private CarElement[] elements;

    public Car() {
        this.elements = new CarElement[] {
            new Wheel("front left"),
            new Wheel("front right"),
            new Wheel("back left"),
            new Wheel("back right"),
            new Body(),
            new Engine()
        };
    }

    public CarElement[] getElements() {
        return this.elements;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
