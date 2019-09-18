package com.manhpd;

import java.util.ArrayList;
import java.util.List;

import com.manhpd.model.AbstractEmployee;
import com.manhpd.model.Employee;
import com.manhpd.model.NullEmployee;

public class Application {

	public static void main(String[] args) {
		List<AbstractEmployee> employees = new ArrayList<AbstractEmployee>() {
			{
				add(new Employee("Obama", "New York", 56));
				add(new Employee("John", "Canada", 25));
				add(new NullEmployee());
			}
		};
		
		employees.stream().forEach(employee -> {
			employee.doSomething();
		});
	}

}
