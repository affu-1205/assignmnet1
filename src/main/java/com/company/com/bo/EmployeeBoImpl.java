package com.company.com.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.com.eo.EmployeeEo;
import com.company.com.exception.ConnectionFailureDB;
import com.company.com.exception.TableNotFoundException;
import com.company.com.model.Employee;
import com.company.com.model.HealthCheck;



@Service("employeeBo")
public class EmployeeBoImpl implements EmployeeBo {
	
	@Autowired
	private EmployeeEo employeeEo;
	
	Logger logger = LoggerFactory.getLogger(EmployeeBoImpl.class);

	@Override
	public List<Employee> getAllEmployee() {
		logger.info("getting data in Bo");
		return employeeEo.getAllEmployee();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.info("saving data in Bo");
		return employeeEo.saveEmployee(employee);
	}

	@Override
	public HealthCheck healthcheck() throws TableNotFoundException{
		logger.debug("Begining of table availability check");
		HealthCheck healthcheck= new HealthCheck();
		healthcheck.setHealthStatus("Check Table is available in db");
	    try{
		    if(getAllEmployee()!=null){
	
		         healthcheck.setHealthComment("Success");
	             healthcheck.setHealthDescription("Table is availabe"); 
	        }
		
	        else if(getAllEmployee().isEmpty()){
		
		         healthcheck.setHealthComment("Failure");
		         healthcheck.setHealthDescription("Table is not availabe"); 
		     }else {
		
	               healthcheck.setHealthComment("Failure");
		            healthcheck.setHealthDescription("Table is not available");
		            throw new ConnectionFailureDB("Db connection lost");
		     }
	    }
	    catch(TableNotFoundException | ConnectionFailureDB ex) {
	    	logger.info("Just a stack trace, nothing to worry about", ex);
	    	
	    }
	    return healthcheck;
	}
	
}
	

