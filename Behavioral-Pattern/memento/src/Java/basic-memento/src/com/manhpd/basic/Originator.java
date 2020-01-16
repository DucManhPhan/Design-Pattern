package com.manhpd.basic;

public class Originator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public Memento saveState() {
        return new Memento(this.state);
    }

    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }

    public static class Memento {

        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        private String getState() {
            return this.state;
        }

    }

}
