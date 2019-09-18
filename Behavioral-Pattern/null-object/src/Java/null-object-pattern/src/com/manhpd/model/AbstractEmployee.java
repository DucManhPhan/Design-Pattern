package com.manhpd.model;

public abstract class AbstractEmployee {

	protected String name;

	protected String address;

	protected int age;

	public abstract boolean isNull();

	public abstract void doSomething();

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

}
