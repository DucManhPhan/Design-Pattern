package com.manhpd;

import com.manhpd.elements.Employee;
import com.manhpd.elements.Officer;
import com.manhpd.elements.Person;
import com.manhpd.visitor.Visitor;
import com.manhpd.visitor.VisitorImpl;

public class Application {

    public static void main(String[] args) {
        Person person_Officer = new Officer();
        Person person_Employee = new Employee();

        Visitor visitor = new VisitorImpl();
        person_Officer.accept(visitor);
        person_Employee.accept(visitor);
    }

}
