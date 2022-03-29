package com.manhpd.refactor;

public class Application {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.turnUp();
        fan.turnUp();

        fan.turnDown();
        fan.turnDown();

        fan.turnUp();
    }
}
