package com.company.com.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.com.model.Employee;



@Repository("/employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate1;
	

	Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);


	@Override
	public List<Employee> getAllEmployee() {
		String query1 = "select * from employeevo";
				logger.info("find all the data");
		return jdbcTemplate1.query(query1,(rs,rowNum)->
		new  Employee(
				rs.getInt("employeeId"),
				rs.getString("employeeName")
				)
		);
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		String query = "insert into employeevo values('"+employee.getEmployeeId()+"' ,'"+employee.getEmployeeName()+"')";
		jdbcTemplate1.update(query);
		logger.info("creating");
		return employee;
	}

}
