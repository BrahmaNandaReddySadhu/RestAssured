package RestAssuredMethods;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

public class StaticImportRestAssuredLibrary {
	
	/*
	 *    We dont required create the RestAssuredClass
	 *    
	 *    like 
	 *    
	 *    
	 *    RestAssured.get("url")   --> this line no need 
	 *    
	 *    Instead we can directly use the  get("url") 
	 * 
	 */
	
	@Test
	public void restAssuredStaticImport1() {
	
		Response response=get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getBody().asPrettyString());
	}
	   
	
	
	/*
	 *    We can also directly using the given(),when().then(),get()    without help of the Response class  
	 * 
	 */
	
	
	@Test
	public void restAssuerdStaticImport2() {
		
		baseURI = "https://reqres.in/api";
		given()
		  .get("/users?page=2").
		then()
		  .statusCode(200)
		  .body("data.id[1]",equalTo(8));
		
		
	}
}
