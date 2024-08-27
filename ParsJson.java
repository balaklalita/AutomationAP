import files.payload;
import io.restassured.path.json.JsonPath;

public class ParsJson {

	public static void main(String[] args) {
	
		JsonPath js = new JsonPath(payload.CoursePrice());
		
		int noOfCourses = js.getInt("courses.size()");
		System.out.println("noOfCourses : " +noOfCourses );
		
		int TotalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("TotalAmount : " + TotalAmount );

		String FirstCourseTitle = js.getString("courses[0].title");
		System.out.println("FirstCourseTitle : " + FirstCourseTitle );
		
		String SecondCourseTitle = js.getString("courses[1].title");
		System.out.println("SecondCourseTitle : " + SecondCourseTitle );
		
		String ThirdCourseTitle = js.getString("courses[2].title");
		System.out.println("ThirdCourseTitle : " + ThirdCourseTitle );
		
		System.out.println("\n---print using for loop---" );
		int i=0;
		for (i=0; i<noOfCourses; i++) {
			System.out.print(	js.getString("courses["+i+"].title"));
			System.out.println(	" : $" + js.getString("courses["+i+"].price"));
		}
			
		System.out.println("\n---print copies for RPA---" );
		String CourseTitle;
		for (i=0; i<noOfCourses; i++) {
			CourseTitle = js.getString("courses["+i+"].title");
			if( CourseTitle.equalsIgnoreCase("RPA")) {
				System.out.println(	"Copies : " + js.getString("courses["+i+"].copies"));	
			}
		}
		
		System.out.println("\n---print copies for RPA---" );
		int CourseUnitPrice;
		int NoOfCopiesByTitle;
		int TotalCalculatedPrice=0;
		for (i=0; i<noOfCourses; i++) {
			CourseUnitPrice    = js.getInt("courses["+i+"].price");
			NoOfCopiesByTitle  = js.getInt("courses["+i+"].copies");
			TotalCalculatedPrice += CourseUnitPrice * NoOfCopiesByTitle;
		}
		System.out.println(	"TotalCalculatedPrice : " +TotalCalculatedPrice);
		if (TotalCalculatedPrice == TotalAmount ) {
			System.out.println(	"Total Match : PASS");
		} else {
			System.out.println(	"Total did NOT Match : FAIL");
		}
	}

}
