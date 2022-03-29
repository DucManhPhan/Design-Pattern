package com.manhpd.refactor;

import java.util.ArrayList;
import java.util.List;

public class GroceryList implements Groceries {

    private List<Groceries> groceries = new ArrayList<>();

    public GroceryList() {
        Bread bread = new Bread();
        Bread bread2 = new Bread();
        Milk milk = new Milk();

        this.groceries.add(bread);
        this.groceries.add(milk);
        this.groceries.add(bread2);
    }

    @Override
    public double getPrice() {
        return this.groceries.stream()
                             .mapToDouble(Groceries::getPrice)
                             .sum();
    }

    @Override
    public void accept(Visitor visitor) {
        this.groceries.forEach(g -> g.accept(visitor));
        visitor.visit(this);
    }
}
