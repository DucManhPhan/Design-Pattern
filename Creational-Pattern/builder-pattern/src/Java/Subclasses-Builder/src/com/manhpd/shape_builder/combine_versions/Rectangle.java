package com.manhpd.shape_builder.combine_versions;

public class Rectangle extends Shape {

    private final double height;

    public static abstract class Builder<T extends Rectangle.Builder<T>> extends Shape.Builder<T> {
        private double height;

        public T height(double height) {
            this.height = height;
            return self();
        }

        public Rectangle build() {
            return new Rectangle(this);
        }
    }

    private static class DefaultRectangleBuilder extends Rectangle.Builder<DefaultRectangleBuilder> {

        @Override
        protected DefaultRectangleBuilder self() {
            return this;
        }
    }

    public static Builder<?> builder() {
        return new DefaultRectangleBuilder();
    }

    protected Rectangle(Builder<?> builder) {
        super(builder);
        this.height = builder.height;
    }

    public double getHeight() {
        return this.height;
    }
}
