package com.manhpd;

import com.manhpd.model.Circle;
import com.manhpd.utils.Factory;

import java.awt.*;
import java.util.List;

public class FactoryApplication {

    public static void main(String[] args) {
        Factory<Circle> factory = Factory.createFactory(Circle::new, Color.RED);
        Factory<Circle> factory1 = Factory.createFactory(Circle::new);

        Circle circle = factory.get();
        System.out.println("Circle = " + circle);

        List<Circle> lst = factory.get5Circles();
        System.out.println("List = " + lst);
    }

}
