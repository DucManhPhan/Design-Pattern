package com.manhpd.nutrition_builder;

public class GMOFacts extends NutritionFacts {

    private final boolean hasGMO;

    public static class Builder extends NutritionFacts.Builder<Builder> {

        private boolean hasGMO = false;

        public Builder() {
            // nothing to do
        }

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder GMO(boolean val) {
            this.hasGMO = val;
            return this;
        }

        public GMOFacts build() {
            return new GMOFacts(this);
        }

    }

    protected GMOFacts(Builder builder) {
        super(builder);
        hasGMO = builder.hasGMO;
    }

    @Override
    public String toString() {
        return "Calories: " + super.toString() + ", has GMO: " + this.hasGMO;
    }
}
