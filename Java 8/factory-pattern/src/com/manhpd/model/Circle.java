package com.manhpd.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle() {
        this.color = Color.WHITE;
    }

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [color = " + color + "]";
    }

}
