package com.manhpd.utils;

import com.manhpd.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    default List<T> get5Circles() {
        return IntStream.range(0, 5)
                 .mapToObj(index -> newInstance())
                 .collect(Collectors.toList());
    }

    /**
     * Using singleton for this factory
     * @param supplier
     * @param <T>
     * @return
     */
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    /**
     *
     * @param constructor
     * @param color
     * @param <T>
     * @param <P>
     * @return
     */
    static <T, P> Factory<T> createFactory(Function<P, T> constructor, P color) {
        return () -> constructor.apply(color);
    }

}
