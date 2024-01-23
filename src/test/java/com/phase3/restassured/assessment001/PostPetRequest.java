package com.phase3.restassured.assessment001;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostPetRequest {
	private static final String BASE_URL = "https://petstore.swagger.io/v2";
	
	@Test
	public void testPost() {
		
		String data = "{\r\n"
				+ "\"id\": 344,\r\n"
				+ "\"category\": {\r\n"
				+ " \"id\": 0,\r\n"
				+ " \"name\": \"string\"\r\n"
				+ "},\r\n"
				+ "\"name\": \"Doggie\",\r\n"
				+ "\"photoUrls\": [\r\n"
				+ " \"string\"\r\n"
				+ "],\r\n"
				+ "\"tags\": [\r\n"
				+ " {\r\n"
				+ " \"id\": 0,\r\n"
				+ " \"name\": \"string\"\r\n"
				+ " }\r\n"
				+ "],\r\n"
				+ "\"status\": \"available\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response res =RestAssured.given().baseUri(BASE_URL)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(data)
		.when()
		.post("/pet");
		System.out.println(res.asPrettyString());
		
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("name",equalTo("Doggie"));
		res.then().assertThat().body("status",equalTo("available"));
	}
	
	

}
