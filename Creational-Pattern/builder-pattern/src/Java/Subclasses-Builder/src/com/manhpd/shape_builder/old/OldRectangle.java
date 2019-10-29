package com.manhpd.shape_builder.old;

public class OldRectangle extends OldShape {

    private final double height;

    public static class Builder extends OldShape.Builder {
        private double height;

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        @Override
        public OldRectangle build() {
            return new OldRectangle(this);
        }

    }

    protected OldRectangle(Builder builder) {
        super(builder);
        this.height = builder.height;
    }

    @Override
    public String toString() {
        return "Height of rectangle is: " + this.height + ", and " + super.toString();
    }
}
