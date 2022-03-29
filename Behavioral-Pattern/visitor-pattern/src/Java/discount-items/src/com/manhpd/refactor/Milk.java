package com.manhpd.refactor;

public class Milk implements Groceries {

    private double price = 2;

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
