package com.manhpd;


/**
 * - Only one instance created.
 * - Guarantees control of a resource.
 * - Lazily loaded.
 * - Examples:
 *      - Runtime
 *      - Logger
 *      - Spring Beans
 *      - Graphic Managers
 *
 * No parameters required for construction.
 *      If we require parameters that is typically a factory pattern
 *      and violates the rules of a singleton.
 *
 */
public class Application {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1);
        System.out.println(singleton2);
    }

}
