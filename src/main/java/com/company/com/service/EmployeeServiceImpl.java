package com.company.com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.com.bo.EmployeeBo;
import com.company.com.mapper.EmployeeMapper;
import com.company.com.model.EmployeeVo;
import com.company.com.model.HealthCheck;



@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeBo employeeBo;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<EmployeeVo> getAllEmployee() {
		logger.info("retrieving data in service");
		return employeeMapper.toEmployeeVo(employeeBo.getAllEmployee());
	}

	@Override
	public EmployeeVo saveEmployeeVo(EmployeeVo employeevo) {
		logger.info("saving data in service ");
		return employeeMapper.toEmployeeVo(employeeBo.saveEmployee(employeeMapper.toEmployee(employeevo)));
	}

	@Override
	public HealthCheck healthcheck() {
		logger.info("health check in progress");
		return employeeBo.healthcheck();
	}

	

}
