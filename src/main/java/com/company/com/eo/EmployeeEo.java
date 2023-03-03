package com.company.com.eo;

import java.util.List;

import com.company.com.model.Employee;


public interface EmployeeEo {

	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee employee);
}
