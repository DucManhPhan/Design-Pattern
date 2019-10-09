package com.manhpd;

public class Application {

    public static void main(String[] args) {
        GMOFacts.Builder b = new GMOFacts.Builder();
        b.GMO(true)
         .calories(100);
        GMOFacts gmoFacts = b.build();
    }

}

class NutritionFacts {

    private final int calories;

    protected NutritionFacts(Builder builder) {
        calories = builder.calories;
        System.out.println("Calories in subclasses NutritionFacts: " + calories);
    }

    public static class Builder {
        private int calories = 0;

        public Builder() {}

        public Builder calories(int val) { calories = val; return this; }

        public NutritionFacts build() { return new NutritionFacts(this); }
    }
}

class GMOFacts extends NutritionFacts {

    private final boolean hasGMO;

    protected GMOFacts(Builder builder) {
        super(builder);
        hasGMO = builder.hasGMO;
        System.out.println("hasGMO in GMOFacts: " + hasGMO);
    }

    public static class Builder extends NutritionFacts.Builder {

        private boolean hasGMO = false;

        public Builder() {}

        public Builder GMO(boolean val) { hasGMO = val; return this; }

        public GMOFacts build() { return new GMOFacts(this); }
    }
}