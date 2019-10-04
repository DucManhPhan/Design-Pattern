package com.manhpd.registry;

import com.manhpd.factory.Factory;
import com.manhpd.model.Circle;
import com.manhpd.model.Shape;
import com.manhpd.model.Square;
import com.manhpd.model.Triangle;

public class SwitchRegistry {

    /**
     * Problem with factory method
     * This is an easy to understand pattern, and easy to implement.
     * Problem: we need to know the shapes at compile time ...
     * What about making it dynamic ?
     *
     * So, how can we add elements dynamically to a registry ?
     *
     * Can be achieved with a Builder pattern?
     * - add elements to the registry
     * - build the registry and seal it
     *
     * There are many examples of this pattern in the JDK: Stream.Builder
     *
     * @param shape
     * @return
     */
    public Factory<? extends Shape> buildShapeFactory(String shape) {
        switch (shape) {
            case "square":
                return () -> new Square();

            case "triangle":
                return () -> new Triangle();

            case "circle":
                return () -> new Circle();

            default:
                throw new IllegalArgumentException("Unknown shape " + shape);
        }
    }

}
