package com.manhpd.refactor;

public interface Groceries {
    double getPrice();

    void accept(Visitor visitor);
}
