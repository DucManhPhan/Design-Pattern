package com.manhpd.pool;

import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {

    private long timeout;

    private Hashtable<T, Long> lockPool;

    private Hashtable<T, Long> unlockPool;

    public ObjectPool() {
        timeout = 10000;
        lockPool = new Hashtable<>();
        unlockPool = new Hashtable<>();
    }

    abstract T create();

    abstract boolean validate(T o);

    abstract void dead(T o);

    synchronized T takeOut() {
        long now = System.currentTimeMillis();
        T t;

        if (this.unlockPool.size() > 0) {
            Enumeration<T> e = this.unlockPool.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - this.unlockPool.get(t)) > this.timeout) {
                    this.unlockPool.remove(t);
                    this.dead(t);
                    t = null;
                } else {
                    if (this.validate(t)) {
                        this.unlockPool.remove(t);
                        this.lockPool.put(t, now);
                        return t;
                    } else {
                        this.unlockPool.remove(t);
                        this.dead(t);
                        t = null;
                    }
                }
            }
        }

        // no objects available, create a new one
        t = create();
        this.lockPool.put(t, now);
        return t;
    }

    synchronized void takeIn(T t) {
        this.lockPool.remove(t);
        this.unlockPool.put(t, System.currentTimeMillis());
    }

}
