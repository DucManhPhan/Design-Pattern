package com.manhpd;


import com.manhpd.model.Circle;
import com.manhpd.model.Shape;
import com.manhpd.model.Square;
import com.manhpd.model.Triangle;
import org.w3c.dom.ls.LSOutput;

import java.util.stream.Stream;

/**
 * A registry can also build other objects
 *
 */
public class RegistryApplication {

    public static void main(String[] args) {

        // Problem: example of the StreamBuilder
        // First, create a Stream.Builder object
        // Then add elements to the builder
        // Then build the stream

        // But we have several problems here:
        // - two phases
        // - the builder has to know the factory
        // In fact, the factory needs the builder --> tightly coupling between factory and builder
        Stream.Builder<String> builder = Stream.builder();
        builder.add("one");
        builder.add("two");
        builder.add("three");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);

        // Solution: Builder can be made independent of the factory

    }




}
