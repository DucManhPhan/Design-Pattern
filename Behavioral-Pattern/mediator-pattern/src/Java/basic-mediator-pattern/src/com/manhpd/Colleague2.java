package com.manhpd;

public class Colleague2 extends Colleague {

    private String state;

    public Colleague2(Mediator mediator) {
        super(mediator);
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        if (!state.equals(this.state)) {
            this.state = state;
            System.out.println("Colleague2: My state changed to: " + this.state + " Calling my mediator ...");
            this.mediator.mediate(this);
        }
    }

    void action2(String state) {
        this.state = state;
        System.out.println("Colleague1: My state synchronized to: " + this.state);
    }
}
