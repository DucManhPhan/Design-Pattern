package com.manhpd;

/**
 * Use lazy loading && thread safe
 *
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create.");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}
