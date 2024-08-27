import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

import files.payload;

public class POST_to_insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Validate the if Add Please API working
		// give, When and Then
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	    String response= given().log().all()
	    .queryParam("key", "qaclick123")
	    .header("Content-Type", "application/json")
	    .body(payload.addPlace())
	    .when().post("maps/api/place/add/json")
	    .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.body("status",equalTo("OK")).header("Server", equalTo( "Apache/2.4.52 (Ubuntu)"))
		.extract().response().asString();
	    
	    System.out.println("\n----response as String is below------");
		System.out.println(response);

		System.out.println("\n----parse using JsonPath class------");
		JsonPath js= new JsonPath(response);
		
		String placeId =js.getString("place_id");
		System.out.println("place_id   :" + placeId);

		String reference =js.getString("reference");
		System.out.println("reference  :" + reference);
		
		String id =js.getString("id");
		System.out.println("id  :" + id);
		
		String status =js.getString("status");
		System.out.println("status   :" + status);
		
		String scope =js.getString("scope");
		System.out.println("scope   :" + scope);
		
		
	}



}
