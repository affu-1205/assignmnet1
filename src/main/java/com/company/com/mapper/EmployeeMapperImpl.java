package com.company.com.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.com.model.Employee;
import com.company.com.model.EmployeeVo;

import jakarta.annotation.Generated;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2021-07-13T14:45:56+0200",
	    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
	)

@Component
public class EmployeeMapperImpl implements EmployeeMapper{

	@Override
	public List<EmployeeVo> toEmployeeVo(List<Employee> list) {
		if(list == null) {
		   return new ArrayList<>();
		}
		List<EmployeeVo> list1 = new ArrayList<EmployeeVo>(list.size());
		for(Employee employee : list) {
			list1.add(toEmployeeVo(employee));
		}
		return list1;
	}

	@Override
	public List<Employee> toEmployees(List<EmployeeVo> list) {
		if(list == null) {
			   return new ArrayList<>();
		}
		List<Employee> list1 = new ArrayList<Employee>(list.size());
		for(EmployeeVo employeeVo : list) {
			list1.add(toEmployee(employeeVo));
		}
		return list1;
	}

	@Override
	public Employee toEmployee(EmployeeVo employee) {
		if(employee == null) {
			   return null;
		}
		Employee employee1 = new Employee();
		employee1.setEmployeeId(employee.getEmployeeId());
		employee1.setEmployeeName(employee.getEmployeeName());
		return employee1;
	}

	@Override
	public EmployeeVo toEmployeeVo(Employee employee1) {
		if(employee1 == null) {
			   return null;
		}
		EmployeeVo employee2 = new EmployeeVo();
		employee2.setEmployeeId(employee1.getEmployeeId());
		employee2.setEmployeeName(employee1.getEmployeeName());
		return employee2;
	}
}
