package com.manhpd.factory_method.factory;

import com.manhpd.factory_method.model.Circle;
import com.manhpd.factory_method.model.Rectangle;
import com.manhpd.factory_method.model.Shape;
import com.manhpd.factory_method.model.Square;

public class ShapeFactory {

	public static Shape getShape(ShapeType type) {
		switch (type) {
		case CIRCLE:
			return new Circle();

		case SQUARE:
			return new Square();

		case RECTANGLE:
			return new Rectangle();

		default:
			return null;
		}
	}

}
