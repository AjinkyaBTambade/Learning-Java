package com.jdbc.connt;

public class Employee {
	private int id;
	private String name;
	private String department;
	private double salary;



//Getter for id 
	public int getId() {
		return id;
	}

// Setter for id
	public void setId(int id) {
		this.id = id;
	}

// Getter for name
	public String getName() {
		return name;
	}

// Setter for name
	public void setName(String name) {
		this.name = name;
	}

// Getter for department
	public String getDepartment() {
		return department;
	}

// Setter for department
	public void setDepartment(String department) {
		this.department = department;
	}

// Getter for salary
	public double getSalary() {
		return salary;
	}

// Setter for salary
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
}
