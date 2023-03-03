package com.company.com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "3.0.0", description = "Employees Information"))
public class Assignment11Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment11Application.class, args);
	}
}
