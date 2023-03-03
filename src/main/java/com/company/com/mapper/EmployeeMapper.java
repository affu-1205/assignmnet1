package com.company.com.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.company.com.model.Employee;
import com.company.com.model.EmployeeVo;


@Mapper(componentModel = "Spring")
public interface EmployeeMapper {

	List<EmployeeVo> toEmployeeVo(List<Employee> list);
	List<Employee> toEmployees(List<EmployeeVo> list);
	Employee toEmployee(EmployeeVo employee);
	EmployeeVo toEmployeeVo(Employee employee1);
}
