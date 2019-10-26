package testCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.apache.commons.lang3.RandomStringUtils;

public class Demo3_PUT_request {
	
	String empName=RandomStringUtils.randomAlphabetic(5);
	String empSalary=RandomStringUtils.random(4);
	String empAge = RandomStringUtils.random(2);
	int emp_id=11254;
	public static HashMap map = new HashMap();
	@BeforeClass
	public void putBody() {
		map.put("name", empName);
		map.put("salary",empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPutRequest() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200);
	}
	
}
