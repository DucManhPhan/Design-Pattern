package com.manhpd.registry;

import com.manhpd.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);

}
