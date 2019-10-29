package com.manhpd;

import com.manhpd.shape_builder.combine_versions.Rectangle;
import com.manhpd.shape_builder.old.OldRectangle;
import com.manhpd.shape_builder.other_version.X;
import com.manhpd.shape_builder.other_version.Y;

public class Application {

    public static void main(String[] args) {
        // nutrition builder
//        GMOFacts.Builder b = new GMOFacts.Builder();
//        b.calories(100).GMO(true);
//
//        GMOFacts gmo = b.build();
//        String result = gmo.toString();
//        System.out.println(result);

        // Shape builder
        // This code is not compile
        // Because we have Rectangle.Builder inherits its opacity() method from Shape.Builder.
        // That method is declared to return "this" pointer of Shape.Builder.
        // But Shape.Builder does not have a height() method.
        // If we switch two line between height() method and opacity() method, it will notify error when compiling.
        // Because our opacity() method will return "this" pointer of Shape.Builder.
        // So, when utilizing build() method, it will call build() method of Shape.Builder, then return Shape object.
        // Therefore, we need to cast from Shape object to Rectangle object as the following code.
//        OldRectangle r = (OldRectangle) new OldRectangle.Builder()
//                                    .height(250)
//                                    .opacity(0.5)
//                                    .build();
//
//        System.out.println(r.toString());

        // The nasty solution for this problem is that we will override opacity() method from Shape.Builder class in Rectangle.Builder class.
        // But when we have multiple properties in parent class, we also do all of things again.
        // So bad.

//        public class Rectangle extends Shape {
//            ...
//            public static class Builder extends Shape.Builder {
//                ...
//                @Override
//                public Builder opacity(double opacity) {
//                    super.opacity(opacity);
//                    return this;
//                }
//                ...

        // Another solution
        // The drawback of above problems is that it does not return compatible "this" pointer of which Builder.
        // So, we will use generics to do that.
//        Rectangle rect = Rectangle.builder()
//                                    .opacity(0.5)
//                                    .height(500)
//                                    .build();
//
//        System.out.println(rect.toString());

        // Or we have
//        Y y = new Y.Builder().withFoo(1).withBar(2).withTaz(5).build();
//        System.out.println(y.getFoo() + " - " + y.getBar() + " - " + y.getTaz());

        // Or we have:
        Rectangle rectangle = Rectangle.builder().opacity(0.10).height(500).build();
        System.out.println(rectangle.getOpacity() + " - " + rectangle.getHeight());
    }

}