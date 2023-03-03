package com.company.com.dao;

import java.util.List;

import com.company.com.model.Employee;



public interface EmployeeDao {

	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee employee);
}
