package com.company.com.model;

import javax.validation.constraints.NotNull;

public class EmployeeVo {
	
	@NotNull
	private int employeeId;
	
	@NotNull
	private String employeeName;


	public EmployeeVo() {
		super();
	}


	public EmployeeVo(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}


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

	
}