package RestAssuredMethods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.lang.Newify;
import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class GetAndPostMethods {

	@Test
	public void get() {

		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("Lindsay", "Byron"));

	}

	/*
	 * In the post we need to provide the body or payload
	 * 
	 * so we can use the Map
	 * 
	 */
	@Test
	public void postRequest() {

		// 1stway

//		Map<String, Object> payloadBody = new HashMap<String, Object>();
//		
//		payloadBody.put("name", "sadhu");
//		payloadBody.put("job", "Tester");
//		JSONObject request = new JSONObject(payloadBody);
//		System.out.println(request);  //    {"name":"sadhu","job":"Tester"}
//		

		// 2nd way

		JSONObject jsonObjet = new JSONObject();

		jsonObjet.put("name", "sadhu");
		jsonObjet.put("job", "developer");

		System.out.println(jsonObjet); // {"name":"sadhu","job":"developer"}

		given().headers("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonObjet.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}
	
	
	
	@Test
	public void postRequestOther() {
		baseURI="https://reqres.in/api";
		
		Map<String, Object>  dataMap = new HashMap<String, Object>();
		
		
		dataMap.put("email", "Brahma@gmail.com");
		dataMap.put("password", "DataEngneer");
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(new JSONObject(dataMap).toJSONString()).
		
		when().post("/register").then().statusCode(400).log().all();
		
		
	}

}
