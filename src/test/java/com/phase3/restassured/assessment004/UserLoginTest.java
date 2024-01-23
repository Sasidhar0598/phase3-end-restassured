package com.phase3.restassured.assessment004;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserLoginTest {
private static final String BASE_URL = "https://petstore.swagger.io/v2/user/login";
	
	@Test(description = "Test for executing GET request using rest assured")
	public void getLoginRequestTest() {
		// paginated response params
		
		
		
		
		Response res =RestAssured.given().baseUri(BASE_URL).queryParam("username", "Uname001").queryParam("password", "sasi123")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get();
		res.then().statusCode(200);
		
		System.out.println(res.asPrettyString());
		
		res.then().assertThat()
		.body("code", equalTo(200));
		
	}	
	

}
