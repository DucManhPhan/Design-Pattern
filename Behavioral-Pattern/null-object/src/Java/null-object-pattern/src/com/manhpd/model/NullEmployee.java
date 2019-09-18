package com.manhpd.model;

public class NullEmployee extends AbstractEmployee {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public void doSomething() {
		System.out.println("Nothing do something.");
	}

}
