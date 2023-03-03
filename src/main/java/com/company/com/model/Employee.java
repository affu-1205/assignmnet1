package com.company.com.model;

import javax.validation.constraints.NotNull;

public class Employee {

	@NotNull
	private int employeeId;
	
	@NotNull
	private String employeeName;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public Employee() {
		super();
	}
}
