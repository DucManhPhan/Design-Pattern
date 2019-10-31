package com.manhpd.shape_builder.refactor_builder_subclass;

public class Rectangle extends Shape {

    private final double height;

    public static abstract class Builder<T extends Rectangle, B extends Rectangle.Builder<T, B>> extends Shape.Builder<T, B> {
        private double height;

        @SuppressWarnings("unchecked")
        public B height(double height) {
            this.height = height;
            return (B) this;
        }
    }

    public static class DefaultRectangleBuilder extends Rectangle.Builder<Rectangle, DefaultRectangleBuilder> {

        @Override
        public Rectangle build() {
            return new Rectangle(this);
        }
    }

    public static Rectangle.Builder<?, ?> builder() {
        return new DefaultRectangleBuilder();
    }

    protected Rectangle(Rectangle.Builder<?, ?> builder) {
        super(builder);
        this.height = builder.height;
    }

    @Override
    public String toString() {
        return "This is Rectangle class";
    }
}