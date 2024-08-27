import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.Assert;

import files.payload;

public class PUT_update_API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Validate the if Add Please API working
		// give, When and Then
		 System.out.println("\n\n\npost");
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

		 
		
		//*
		//* Update address by using update API
		//*
		System.out.println("\n\n\n put");
		
		given().log().all()
	    .queryParam("key", "qaclick123")
	    .header("Content-Type", "application/json")
	    .body("{ \r\n"
	    		+ "\"plae_id\":\""+placeId+"\",\r\n"
	    		+ "\"address\":\"50 summer Walk, USA\",\r\n"
	    		+ "\"key\":\"qaclick123\"\r\n"
	    		+ "}")
	    .when().put("maps/api/place/update/json")
	    .then().assertThat().log().all().statusCode(200);
	   
	    //.body("msg",equalTo("Address successfully updated"))
		//.body("status",equalTo("OK"))
	    
	
		//*
		//* get address by using get API
		//*
		
		 System.out.println("\n\n\nget");
		    
		
	    String responseget=given().log().all()
	    .queryParam("key", "qaclick123")
	    .queryParam("place_id", placeId)
	    .when().get("maps/api/place/get/json")
	    .then().assertThat().log().all().statusCode(200)
	    .extract().response().asString();
	    System.out.println(responseget);
	    
	    JsonPath js1 =new JsonPath(responseget);
	    String name= js1.getString("name");
	    System.out.println(name);
	    String location = js1.getString("location");
	    System.out.println(location);
	    String ActualAddress =js1.getString("address");
	    System.out.println(ActualAddress);
	    
	    String expectedAddress = "520 Lasalle Ct, Buffalo Grove";
	    //TestNG
	    Assert.assertEquals(ActualAddress, expectedAddress);
		
	}
}
