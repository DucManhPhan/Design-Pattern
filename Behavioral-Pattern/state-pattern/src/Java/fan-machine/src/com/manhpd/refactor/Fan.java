package com.manhpd.refactor;

public class Fan {

    private State state = new LowState();

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void turnUp() {
        this.getState().turnUp(this);
    }

    public void turnDown() {
        this.getState().turnDown(this);
    }

}
