package com.manhpd.factory;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <T, P> Factory<T> createFactory(Function<P, T> constructor, P color) {
        return () -> constructor.apply(color);
    }

}
