package com.manhpd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int id;

	private String firstName;

	private String lastName;

	private String position;

	public Employee(EmployeeBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.position = builder.position;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nPosition: " + position;
	}

	public static class EmployeeBuilder {

		private int id;

		private String firstName;

		private String lastName;

		private String position;

		public EmployeeBuilder id(int id) {
			this.id = id;
			return this;
		}

		public EmployeeBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public EmployeeBuilder position(String position) {
			this.position = position;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}

}
