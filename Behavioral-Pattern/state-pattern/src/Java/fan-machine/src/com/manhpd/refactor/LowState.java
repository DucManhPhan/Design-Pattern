package com.manhpd.refactor;

public class LowState implements State {

    @Override
    public void turnUp(Fan fan) {
        fan.setState(new MediumState());
        System.out.println("Fan is on medium.");
    }

    @Override
    public void turnDown(Fan fan) {}
}
