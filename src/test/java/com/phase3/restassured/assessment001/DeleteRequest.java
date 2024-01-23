package com.phase3.restassured.assessment001;

import static org.hamcrest.CoreMatchers.equalTo;

//import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequest {
	
private static final String BASE_URL = "https://petstore.swagger.io/v2";
	
	@Test(description = "Test for executing POST request using rest assured")
	public void deleteRequestTest() { 
		// create user post data
		
		RestAssured.given().baseUri(BASE_URL)
		.contentType(ContentType.JSON)
		.when().delete("/pet/344")
		.then().statusCode(200).and()
		.assertThat().body("code", equalTo(200))
		.assertThat().body("message", equalTo("344"));
	}
}
