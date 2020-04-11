package com.manhpd;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private static final FlyweightFactory INSTANCE = new FlyweightFactory();

    private FlyweightFactory() {
        // nothing to do
    }

    public static FlyweightFactory getInstance() {
        return INSTANCE;
    }

    private Map<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            System.out.println("Sharing a flyweight with key = " + key);
            return flyweights.get(key);
        } else {
            System.out.println("Creating a flyweight with key = " + key);
            Flyweight flyweight = new Flyweight1(key);
            flyweights.put(key, flyweight);
            return flyweight;
        }
    }

    public int getSize() {
        return flyweights.size();
    }

}
