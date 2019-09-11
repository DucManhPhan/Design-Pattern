package com.manhpd.factory_method;

import com.manhpd.factory_method.factory.ShapeFactory;
import com.manhpd.factory_method.factory.ShapeType;
import com.manhpd.factory_method.model.Shape;

/**
 * Apply Factory method pattern with Shape inheritance
 * 
 *
 */
public class App {
	public static void main(String[] args) {
		Shape circle = ShapeFactory.getShape(ShapeType.CIRCLE);
		circle.draw();

		Shape square = ShapeFactory.getShape(ShapeType.SQUARE);
		square.draw();
	}
}
