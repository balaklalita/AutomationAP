import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class SecondApiAutomationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.basePath="https://rahulshettyacademy.com";
		given().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
	    .body(payload.addPlace())
	    .when().post("maps/api/place/add/json")
	    .then().log().all().assertThat().statusCode(200);
	}	
}