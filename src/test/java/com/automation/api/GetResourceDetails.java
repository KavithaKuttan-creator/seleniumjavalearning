package com.automation.api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetResourceDetails {
	
	@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
	

    @Test
    public void testUserApi() {
        
        String response = sendGetRequest("/users/2");
        attachResponse(response);
        attachConsoleLog("API response: " + response);
        
    }

	
	 @Test(description = "Verify user API")
    @Description("This test verifies that the user API returns status 200")
	public String sendGetRequest(String path) {
		
		 return given().
			
			header("Accept", "application/json")
		.when()
			.get(path)
		  .then()
			.log().all()
			.statusCode(200)
			.body("id",equalTo(2))
			.extract().asString();
	}
	
	//Get all posts
	 
	    @Step("This test verifies all posts")
	public void getAllposts() {
		given().
			header("Accept","application/json").
		when()
			.get("/posts")
		.then()
			.log().all()
			.statusCode(200)
			.body("size()",greaterThan(0));
			
	}
	
	@Step("POST DATA")
	public void postData()
	{
		String postBody = "{"
				+"\"id\":103,"
				+"\"userid\":102,"
				+"\"title\":\"automation testing1\","
				+"\"body\":\"Test Content1\""
			+"}";
		
				
		given()
			.header("Content-Type","application/json")
			.body(postBody)
		.when()
			.post("/posts")
		.then()
			.log().all()
			.statusCode(201)
			.body("id",equalTo(103));
	}
	
	@Step("DELETE")
	public void deleteData() {
		when().
			delete("posts/101")
		.then()	
			.statusCode(200).
			log().all();
	}
	
	@Attachment(value = "API Response", type = "application/json")
	public String attachResponse(String response) {
		return response;
	}

	@Attachment(value = "Console Log", type = "text/plain")
	public static String attachConsoleLog(String log) {
	    return log;
	}
}
