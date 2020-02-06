package com.manhpd;

public class ConcreteObserver implements IObserver {

    private String nameObserver;

    private ISubject subject;

    public ConcreteObserver(String name) {
        this.nameObserver = name;
    }

    @Override
    public void update() {
        String state = this.subject.getState();
        System.out.println("Observer " + this.nameObserver + " received state from subject is: " + state);
    }

    @Override
    public void saveSubject(ISubject subject) {
        this.subject = subject;
    }
}
