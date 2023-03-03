package com.company.com.service;

import java.util.List;

import com.company.com.model.EmployeeVo;
import com.company.com.model.HealthCheck;


public interface EmployeeService {

	public List<EmployeeVo> getAllEmployee();

	public EmployeeVo saveEmployeeVo(EmployeeVo employeevo);

	public HealthCheck healthcheck();


}
