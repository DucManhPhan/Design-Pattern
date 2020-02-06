package com.manhpd;

public class Application {

    public static void main(String[] args) {
        final CarElement car = new Car();
        car.accept(new CarElementPrintVisitor());
    }

}
