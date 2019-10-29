package com.manhpd.nutrition_builder;

public class NutritionFacts {

    private final int calories;

    public abstract static class Builder<T extends Builder<T>> {
        private int calories = 0;

        public Builder() {
            // nothing to do
        }

        // solution for unchecked or unsafe operations warning
        public abstract T getThis();

        public T calories(int val) {
            this.calories = val;
            return this.getThis();
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    protected NutritionFacts(Builder<?> builder) {
        this.calories = builder.calories;
    }

    @Override
    public String toString() {
        return Integer.valueOf(this.calories).toString();
    }
}
