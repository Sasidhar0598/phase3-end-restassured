package com.phase3.restassured.assessment002;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest {
	
private static final String BASE_URL = "https://petstore.swagger.io/v2";
	
	@Test
	public void testPost() {
		
		String status="QA";
		
		
		String data = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		Response res =RestAssured.given().baseUri(BASE_URL)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(data)
		.when()
		.put("/pet");
		System.out.println(res.asPrettyString());
		
		Map<String,String> env = new HashMap<>();
		env.put("DEV", "available_DEV");
		env.put("QA", "available_QA");
		env.put("PROD", "available_PROD");
		
		

		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("name",equalTo("doggie"));
		res.then().assertThat().body("status",equalTo("available"));
	}


}
