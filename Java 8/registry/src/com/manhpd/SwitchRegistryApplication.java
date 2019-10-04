package com.manhpd;

import com.manhpd.factory.Factory;
import com.manhpd.model.Rectangle;
import com.manhpd.registry.SwitchRegistry;

public class SwitchRegistryApplication {

    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle : " + rectangleFactory.newInstance());
    }

}
