package com.manhpd;

public class Flyweight1 implements Flyweight {

    private String intrinsicState;

    public Flyweight1(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public String operation(int extrinsicState) {
        return "Performing an operation on the flyweight\n "
                          + " with intrinsic state = " + intrinsicState
                          + " and passed in extrinsic state = " + extrinsicState + ".";
    }
}
