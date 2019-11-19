package com.manhpd;


/**
 * When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when loading the class.
 * Inner class is created only when getInstance() method is called.
 * So it may seem like eager initialization but it is lazy initialization.
 * This is the most widely used approach as it doesn’t use synchronization.
 *
 */
public class BillPughSingleton {

    private BillPughSingleton() {
        // nothing to do
    }

    private static class InnerSingleton {
        private static final BillPughSingleton singleton = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return InnerSingleton.singleton;
    }

}
