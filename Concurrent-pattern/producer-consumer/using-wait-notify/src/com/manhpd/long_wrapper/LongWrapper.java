package com.manhpd.long_wrapper;

public class LongWrapper {

    private Object key = new Object();

    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        synchronized (key) {
            return this.l;
        }
    }

    public void incrementValue() {
        synchronized (key) {
            l = l + 1;
        }
    }

}
