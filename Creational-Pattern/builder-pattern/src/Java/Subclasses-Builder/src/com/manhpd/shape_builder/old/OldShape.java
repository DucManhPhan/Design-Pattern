package com.manhpd.shape_builder.old;


/**
 * https://community.oracle.com/blogs/emcmanus/2010/10/24/using-builder-pattern-subclasses
 *
 */
public class OldShape {

    private final double opacity;

    public static class Builder {
        private double opacity;

        public Builder opacity(double opacity) {
            this.opacity = opacity;
            return this;
        }

        public OldShape build() {
            return new OldShape(this);
        }
    }

    protected OldShape(Builder builder) {
        this.opacity = builder.opacity;
    }

    @Override
    public String toString() {
        return "Opacity: " + this.opacity;
    }
}
