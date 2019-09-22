package com.manhpd.utils;

import com.manhpd.model.Circle;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default Circle newInstance() {
        return get();
    }

    default List<T> get5Circles() {
        return IntStream.range(0, 5)
                 .mapToObj(index -> newInstance())
                 .collect(Collectors.toList());
    }

}
