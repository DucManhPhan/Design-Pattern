package com.manhpd.refactor;

public class MediumState implements State {
    @Override
    public void turnUp(Fan fan) {
        fan.setState(new HighState());
        System.out.println("Fan is on high.");
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new LowState());
        System.out.println("Fan is on low");
    }
}
