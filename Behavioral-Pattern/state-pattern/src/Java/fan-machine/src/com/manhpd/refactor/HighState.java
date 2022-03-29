package com.manhpd.refactor;

public class HighState implements State {
    @Override
    public void turnUp(Fan fan) {}

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new MediumState());
        System.out.println("Fan is on medium.");
    }
}
