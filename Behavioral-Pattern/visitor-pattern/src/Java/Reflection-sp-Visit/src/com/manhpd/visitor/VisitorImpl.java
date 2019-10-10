package com.manhpd.visitor;

import com.manhpd.elements.Employee;
import com.manhpd.elements.Officer;
import com.manhpd.elements.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VisitorImpl extends Visitor {

    @Override
    public void visit(Person emp) {
        Method method = this.getMethod(emp.getClass());
        if (method == null) {
            this.defaultVisit(emp);
        } else {
            try {
                method.invoke(this, emp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void visit(Employee emp) {
        System.out.println(emp.getWorkingTime());
    }

    public void visit(Officer officer) {
        System.out.println(officer.getSalary());
    }
}
