package com.company.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.company.com.bo.EmployeeBo;
import com.company.com.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class Assignment11ApplicationTests {
	
    ObjectMapper obj = new ObjectMapper();
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	EmployeeBo employeebo;
	
	@Test
	 void createEmployeesTest() throws Exception{
		Employee emp=new Employee();
		emp.setEmployeeId(1);
		emp.setEmployeeName("afreen");
		 String jsonRequest = obj.writeValueAsString(emp);
	     when(employeebo.saveEmployee(any())).thenReturn(emp);
	     mvc.perform(post("/task1/addemployee1").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)
	                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	 void getEmployeesTest() throws Exception{
		Employee emp= new Employee();
		emp.setEmployeeId(1);
		emp.setEmployeeName("afreen");
		List<Employee> emp1= Arrays.asList(emp);
	     when(employeebo.getAllEmployee()).thenReturn(emp1);
	     mvc.perform(get("/task1/employee1")).andExpect(status().isOk());
	     assertEquals("afreen", emp.getEmployeeName());
		
	}

	
	
	

}
