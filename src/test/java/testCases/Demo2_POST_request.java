package testCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;

public class Demo2_POST_request {

	String firstName = "John"+RandomStringUtils.randomAlphabetic(2);
	String lastName = "Peter"+RandomStringUtils.randomAlphabetic(2);
	String userName = "JohnPeter"+RandomStringUtils.randomAlphabetic(2);
	String password = "PeterJohn"+RandomStringUtils.randomAlphabetic(1);
	String email = RandomStringUtils.randomAlphabetic(4)+"gmail.com";
	public static HashMap map = new HashMap();
	@BeforeClass
	public void postData() {
		map.put("FirstName",firstName);
		map.put("LastName", lastName);
		map.put("UserName", userName);
		map.put("Password", password);
		map.put("Email",email);
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	@Test
	public void testPostedData() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()
			.body("SuccessCode",equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));
	}
}
