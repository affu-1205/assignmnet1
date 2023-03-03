package com.company.com.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.media.Schema;
import com.company.com.model.Employee;
import com.company.com.model.EmployeeVo;
import com.company.com.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/task1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	

	@Operation(summary = "get all employees")
	@ApiResponse(responseCode = "200", description = "found the employee",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = Employee.class)) })
	@ApiResponse(responseCode = "404", description = "employee not found",
	content = @Content)

	@GetMapping("/employee1")
	public ResponseEntity<List<EmployeeVo>> getAllEmployee() {
		List<EmployeeVo> employee1 = employeeService.getAllEmployee();
		logger.info("data is getting in controller");
		
		return ResponseEntity.ok(employee1);
		
	}
	
	

    @Operation(summary = "post method ")
	@ApiResponse(responseCode = "200", description = "employee saved successfully",
	content = { @Content(mediaType = "application/json",
	schema = @Schema(implementation = Employee.class)) })
	@ApiResponse(responseCode = "404", description = "employee not found",
	content = @Content)
	@ApiResponse(responseCode = "500", description = "check employeeid primary key are not ,employeename string are not",
	content = @Content)

	@PostMapping("/addemployee1")
	public ResponseEntity<EmployeeVo> saveEmployeeVo(@Validated @RequestBody EmployeeVo employeevo){
		EmployeeVo employee = employeeService.saveEmployeeVo(employeevo); 
        logger.info("data is getting in controller");
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
	
	
	@GetMapping("/healthcheck1")
	public ResponseEntity<String> healthcheck(){
		logger.info("data is saving in db");
		return new ResponseEntity<String>("healthcheck successful",HttpStatus.OK);
	}

}
