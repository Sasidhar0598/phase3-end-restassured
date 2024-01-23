package com.phase3.restassured.assessment005;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestUsingQueryparam {
	
private static final String BASE_URL = "https://petstore.swagger.io/v2/pet/findByStatus";
	
	@Test(description = "Test for executing GET request using rest assured")
	public void getRequestByStatusTest() {
		// paginated response params
		
		
		
		
		Response res =RestAssured.given().baseUri(BASE_URL).queryParam("status", "available")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get();
		res.then().statusCode(200);
		
		//System.out.println(res.asPrettyString());
		
//		res.then().assertThat()
//		.body("code", equalTo(200));
		
	}
	@Test
	public void getRequestByPendingTest() {
		// paginated response params
		
		
		
		
		Response res =RestAssured.given().baseUri(BASE_URL).queryParam("status", "pending")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get();
		res.then().statusCode(200);
		
		//System.out.println(res.asPrettyString());
		
//		res.then().assertThat()
//		.body("code", equalTo(200));
		
	}
	@Test
	public void getRequestBySoldTest() {
		// paginated response params
		
		
		
		
		Response res =RestAssured.given().baseUri(BASE_URL).queryParam("status", "sold")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get();
		res.then().statusCode(200);
		
		//System.out.println(res.asPrettyString());
		
//		res.then().assertThat()
//		.body("code", equalTo(200));
		
	}

}
