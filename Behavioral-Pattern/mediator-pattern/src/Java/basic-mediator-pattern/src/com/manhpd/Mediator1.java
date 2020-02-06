package com.manhpd;

public class Mediator1 implements Mediator {

    private Colleague1 colleague1;

    private Colleague2 colleague2;

    public void setColleagues(Colleague1 colleague1, Colleague2 colleague2) {
        this.colleague1 = colleague1;
        this.colleague2 = colleague2;
    }

    @Override
    public void mediate(Colleague colleague) {
        System.out.println("Mediator: mediating the interaction ...");
        if (colleague == colleague1) {
            String state = colleague1.getState();
            colleague2.action2(state);
        } else if (colleague == colleague2) {
            String state = colleague2.getState();
            colleague1.action1(state);
        }
    }
}
