package com.JoseK.TestDAO;

import java.sql.Date;

public class User {
	
	private int id;
	private String name;
	private double salary;
	private Date hireDate;

	public User() {
		super();
	}

	public User(String name, double salary, Date hireDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	
}
