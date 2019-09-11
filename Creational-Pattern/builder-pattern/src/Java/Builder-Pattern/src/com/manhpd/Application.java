package com.manhpd;

public class Application {

	public static void main(String[] args) {
		
		Employee emp = new Employee.EmployeeBuilder()
									.id(12)
									.firstName("Obama")
									.lastName("Barack")
									.position("Former President")
									.build();
		
		System.out.println(emp.toString());
	}

}
