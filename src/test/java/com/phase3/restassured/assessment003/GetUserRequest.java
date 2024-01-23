package com.phase3.restassured.assessment003;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserRequest {
	
private static final String BASE_URL = "https://petstore.swagger.io/v2/user/sasi";
	
	@Test(description = "Test for executing GET request using rest assured")
	public void getUserRequestTest() {
		// paginated response params
		
		
		
		
		Response res =RestAssured.given().baseUri(BASE_URL)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get();
		res.then().statusCode(200);
		
		System.out.println(res.asPrettyString());
		
		res.then().assertThat()
		.body("username", equalTo("Uname001"));
		
	}


}
