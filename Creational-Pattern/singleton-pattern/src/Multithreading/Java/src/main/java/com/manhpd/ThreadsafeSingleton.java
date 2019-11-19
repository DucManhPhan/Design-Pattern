package com.manhpd;

public class ThreadsafeSingleton {

    private static ThreadsafeSingleton singleton = null;

    // Use for lazy initialization with double check locking
    // Advantage:
    // - prevent cache incoherence issues.
    private static volatile  ThreadsafeSingleton instance = null;

    private ThreadsafeSingleton() {
        // nothing to do
    }

    /**
     * With this way, it has drawback:
     * - getInstanceFirstWay() method is synchronized so it causes slow performance as multiple threads can not access it simultaneously.
     *
     * @return
     */
    public synchronized static ThreadsafeSingleton getInstanceFirstWay() {
        if (singleton == null) {
            return singleton = new ThreadsafeSingleton();
        }

        return singleton;
    }

    /**
     * Lazy initialization with Double check locking
     *
     * Advantages:
     * - Performance overhead gets reduced because of synchronized keyword.
     * - Lazy initialization is possible.
     * - It is also thread safe.
     *
     * Disadvantages:
     * - since it requires the volatile keyword to work properly, it's not compatible with Java 1.4 and lower versions
     * - it's quite verbose and it makes the code difficult to read
     */
    public static ThreadsafeSingleton getInstanceSecondWay() {
        if (instance == null) {
            // synchronized block to remove block
            synchronized (ThreadsafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadsafeSingleton();
                }
            }
        }

        return instance;
    }

}
