package com.manhpd;

public class Client {

    public static void main(String[] args) {
        Flyweight flyweight;

        // Getting a FlyweightFactory object.
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();

        flyweight = flyweightFactory.getFlyweight("A");
        System.out.println(flyweight.operation(100));

        flyweight = flyweightFactory.getFlyweight("A");
        System.out.println(flyweight.operation(200));

        System.out.println("\n*** Number of flyweights created: "
                + flyweightFactory.getSize() + " ***");
    }

}
