package com.manhpd.model;

public class Employee extends AbstractEmployee {

	public Employee(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public void doSomething() {
		System.out.println(this.getName() + " is doing something.");
	}

}
