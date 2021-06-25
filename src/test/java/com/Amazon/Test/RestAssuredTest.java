package com.Amazon.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest extends BaseTest {

	@Test
	public void getEmployeeDetails() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";
		RequestSpecification request= RestAssured.given();
		request.header("ContentType","application/json");
		Response response=request.get("/"+properties.getProperty("employeeid"));

		String employeeId = response.body().jsonPath().get("data.id").toString();
		String employeeName = response.body().jsonPath().get("data.employee_name").toString();
		String employeeSalary = response.body().jsonPath().get("data.employee_salary").toString();
		String employeeAge = response.body().jsonPath().get("data.employee_age").toString();

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(employeeId, properties.getProperty("employeeid"));	
		Assert.assertNotNull(employeeName);
		Assert.assertNotNull(employeeSalary);
		Assert.assertNotNull(employeeAge);
	}
	
	@Test
	public void validateDeleteEmployeeData() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/delete";
		RequestSpecification request = RestAssured.given();
		request.header("ContentType", "application/json");
		Response response = request.delete("/"+properties.getProperty("deleteemployeeid"));
		
		String deleteResponse = response.body().jsonPath().get("message").toString();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(deleteResponse, "Successfully! Record has been deleted");			
	}
}
