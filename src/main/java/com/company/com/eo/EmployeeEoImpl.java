package com.company.com.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.com.dao.EmployeeDao;
import com.company.com.model.Employee;

@Component("employeeEo")
public class EmployeeEoImpl implements EmployeeEo{

	@Autowired
	private EmployeeDao employeeDao;
	
	Logger logger = LoggerFactory.getLogger(EmployeeEoImpl.class);
	
	@Override
	public List<Employee> getAllEmployee() {
		logger.info("employee data retrived");
		
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.info("employee data saved");
		
		return employeeDao.saveEmployee(employee);
	}

}
