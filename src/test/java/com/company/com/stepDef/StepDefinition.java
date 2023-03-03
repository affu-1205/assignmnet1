package com.company.com.stepDef;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import static io.restassured.RestAssured.*;

import com.company.com.model.Employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@CucumberContextConfiguration
@SpringBootTest(classes=TestConfiguration.class)
public class StepDefinition {
	
	private Response response;
	private RequestSpecification request;

	@Given("provide the data {int},{string}")
	public void provide_the_data(Integer int1,String string) {
		Employee emp = new Employee();
		emp.setEmployeeId(int1);
		emp.setEmployeeName(string);
		request = given().contentType(ContentType.JSON).body(emp);
	}
	
	@When("client calls post method with /employeevo")
	public void client_calls_post_method_with_employeevo() {
		response = request.when().post("http://localhost:7070/task1/addemployee1");
	}
	
	@Then("validate the response {string}")
	public void validate_the_response(String string) {
		int status = response.then().extract().statusCode();
		System.out.println(string);
		assertEquals(200, status);
	}
	
}