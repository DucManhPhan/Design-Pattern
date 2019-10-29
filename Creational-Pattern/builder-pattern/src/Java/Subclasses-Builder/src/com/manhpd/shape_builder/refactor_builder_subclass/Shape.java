package com.manhpd.shape_builder.refactor_builder_subclass;


/**
 * https://chrononaut.org/2012/02/24/subclassing-with-blochs-builder-pattern/
 *
 */
public class Shape {

    private final double opacity;

    public static abstract class Builder <T extends Shape, B extends Shape.Builder<T, B>> {
        private double opacity;

        @SuppressWarnings("unchecked")
        public B opacity(double opacity) {
            this.opacity = opacity;
            return (B) this;
        }

        public abstract T build();
    }

    private static class DefaultShapeBuilder extends Shape.Builder<Shape, DefaultShapeBuilder> {

        @Override
        public Shape build() {
            return new Shape(this);
        }
    }

    public static Builder<?, ?> builder() {
        return new DefaultShapeBuilder();
    }

    protected Shape(Builder<?, ?> builder) {
        this.opacity = builder.opacity;
    }

}