package com.manhpd.visitor;

import com.manhpd.elements.Person;

import java.lang.reflect.Method;

public abstract class Visitor {

    public abstract void visit(Person emp);

    protected Method getMethod(Class<?> clazz) {
        // Check super classes
        while (!clazz.equals(Object.class)) {
            try {
                return this.getClass().getDeclaredMethod("visit", clazz);

            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }

        // Check interfaces
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            try {
                return this.getClass().getDeclaredMethod("visit", i);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    protected void defaultVisit(Person person) {
        System.out.println("This is a person");
    }

}
