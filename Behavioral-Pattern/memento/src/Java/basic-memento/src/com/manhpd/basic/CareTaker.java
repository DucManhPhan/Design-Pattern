package com.manhpd.basic;

public class CareTaker {

    public static void main(String s[]) {
        new CareTaker().runMechanicTest();
    }

    public void runMechanicTest() {
        Originator.Memento savedState = new Originator.Memento("");
        Originator originator = new Originator();
        originator.setState("State1");
        originator.setState("State2");
        savedState = originator.saveState();
        originator.setState("State3");
        originator.restoreState(savedState);
        System.out.println("final state:" + originator.getState());
    }

}
