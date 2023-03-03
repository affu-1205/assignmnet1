package com.company.com.bo;

import java.util.List;

import com.company.com.model.Employee;
import com.company.com.model.HealthCheck;



public interface EmployeeBo {

	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee employee);
	public HealthCheck healthcheck();
}
