package com.phase3.restassured.assessment001;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest {
	
private static final String BASE_URL = "http://petstore.swagger.io/v2/pet/344";
	
	@Test(description = "Test for executing GET request using rest assured")
	public void getRequestTest() {
		// paginated response params
		int id = 344;
		
		
		
		Response res =RestAssured.given().baseUri(BASE_URL)
		.contentType(ContentType.JSON)
		.when().get();
		res.then().statusCode(200);
		
		System.out.println(res.asPrettyString());
		
		res.then().assertThat()
		.body("id", equalTo(id)).and()
		.body("name", equalTo("Doggie")).and()
		.body("status", equalTo("available"));
	}

}
