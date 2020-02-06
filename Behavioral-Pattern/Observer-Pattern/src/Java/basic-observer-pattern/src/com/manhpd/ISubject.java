package com.manhpd;

public interface ISubject {

    void register(IObserver observer);

    void remove(IObserver observer);

    void notifyObservers();

    String getState();

    void changeState(String state);

}
