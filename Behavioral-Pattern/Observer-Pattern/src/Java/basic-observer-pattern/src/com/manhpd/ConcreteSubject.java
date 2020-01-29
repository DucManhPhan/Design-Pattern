package com.manhpd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConcreteSubject implements ISubject {

    private String state;

    private List<IObserver> observers;

    public ConcreteSubject() {
        this.state = "";
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        if (Objects.isNull(observer) || this.observers.contains(observer)) {
            return;
        }

        this.observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (this.observers.isEmpty()) {
            return;
        }

        this.observers.stream().forEach(observer -> observer.update());
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void changeState(String state) {
        this.state = state;
        this.notifyObservers();
    }

}
