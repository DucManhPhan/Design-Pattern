package com.manhpd;

import com.manhpd.factory.Factory;
import com.manhpd.model.Rectangle;
import com.manhpd.model.Shape;
import com.manhpd.model.Square;
import com.manhpd.model.Triangle;
import com.manhpd.registry.Builder;
import com.manhpd.registry.Registry;

import java.util.function.Consumer;

public class RegistryBuilderApplication {

    public static void main(String[] args) {

        Consumer<Builder<Shape>> consumer1 = builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 = builder -> builder.register("triangle", Triangle::new);

        Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2);

        Registry registry = Registry.createRegistry(initializer, s -> {
            throw new IllegalArgumentException("Unknown shape " + s);
        });

        Factory<Rectangle> buildRectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        Rectangle rectangle = buildRectangleFactory.newInstance();
        System.out.println("Rectangle: " + rectangle);

        Factory<Triangle> buildTriangleFactory = (Factory<Triangle>) registry.buildShapeFactory("triangle");
        Triangle triangle = buildTriangleFactory.newInstance();
        System.out.println("Triangle: " + triangle);

        Factory<Square> buildSquareFactory = registry.buildShapeFactory("square");
        Square square = buildSquareFactory.newInstance();
        System.out.println("Square: " + square);
    }

}
