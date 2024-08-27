package files;

public class payload {

	public static String addPlace()
	{
		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    }    ,\r\n"
				+ "    \"accuracy\" : 50,\r\n"
				+ "    \"name\" : \"Lalita Kumari automated\",\r\n"
				+ "    \"phone_number\" : \"(+1) 224 123 1234\",\r\n"
				+ "    \"address\" : \"520 Lasalle Ct, Buffalo Grove\",\r\n"
				+ "    \"types\": [ \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\" : \"http://rahulshettyacademy.com\",\r\n"
				+ "    \"language\" : \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String CoursePrice()
	{
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
				
	}
				
		
}
