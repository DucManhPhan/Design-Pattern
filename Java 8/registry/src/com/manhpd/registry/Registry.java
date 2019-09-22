package com.manhpd.registry;

import com.manhpd.factory.Factory;
import com.manhpd.model.Rectangle;
import com.manhpd.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Registry<T> {

    Factory<? extends T> buildShapeFactory(String shape);

    public static <T> Registry<T> createRegistry(Consumer<Builder<T>> consumer
                                                , Function<String, Factory<T>> errorFunction) {
        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = (label, factory) -> map.put(label, factory);
        consumer.accept(builder);

        System.out.println("Map: " + map);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }

}
