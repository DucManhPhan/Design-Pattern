package com.manhpd.shape_builder.combine_versions;

public class Shape {

    private final double opacity;

    public static abstract class Builder<T extends Shape.Builder<T>> {
        private double opacity;

        protected abstract T self();

        public T opacity(double opacity) {
            this.opacity = opacity;
            return this.self();
        }

        public Shape build() {
            return new Shape(this);
        }
    }

    private static class DefaultShapeBuilder extends Builder<DefaultShapeBuilder> {

        @Override
        protected DefaultShapeBuilder self() {
            return this;
        }
    }

    public static Builder<?> builder() {
        return new DefaultShapeBuilder();
    }

    protected Shape(Builder<?> builder) {
        this.opacity = builder.opacity;
    }

    public double getOpacity() {
        return this.opacity;
    }

}
