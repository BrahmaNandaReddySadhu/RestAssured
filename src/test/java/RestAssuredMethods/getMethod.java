package RestAssuredMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getMethod {

	@Test
	public void get() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.body()); // output: io.restassured.internal.RestAssuredResponseImpl@2b7962a2

		System.out.println(response.getBody()); // output : io.restassured.internal.RestAssuredResponseImpl@2b7962a2

		System.out.println(response.getStatusCode()); // 200

		System.out.println(response.getContentType()); // application/json; charset=utf-8

		System.out.println(response.getStatusLine()); // HTTP/1.1 200 OK

		System.out.println(response.getBody().asString()); // {"page":2,"per_page":6,"total":12,"total_pages":2,"data":[{"id":7,"email":"michael.lawson@reqres.in","first_name":"Michael","last_name":"Lawson","avatar":"https://reqres.in/img/faces/7-image.jpg"},{"id":8,"email":"lindsay.ferguson@reqres.in","first_name":"Lindsay","last_name":"Ferguson","avatar":"https://reqres.in/img/faces/8-image.jpg"},{"id":9,"email":"tobias.funke@reqres.in","first_name":"Tobias","last_name":"Funke","avatar":"https://reqres.in/img/faces/9-image.jpg"},{"id":10,"email":"byron.fields@reqres.in","first_name":"Byron","last_name":"Fields","avatar":"https://reqres.in/img/faces/10-image.jpg"},{"id":11,"email":"george.edwards@reqres.in","first_name":"George","last_name":"Edwards","avatar":"https://reqres.in/img/faces/11-image.jpg"},{"id":12,"email":"rachel.howell@reqres.in","first_name":"Rachel","last_name":"Howell","avatar":"https://reqres.in/img/faces/12-image.jpg"}],"support":{"url":"https://reqres.in/#support-heading","text":"To
															// keep ReqRes free, contributions towards server costs are
															// appreciated!"}}

		System.out.println(response.getHeaders());

		/*
		 * Headers:
		 * 
		 * Date=Mon, 27 Jun 2022 15:52:51 GMT Content-Type=application/json;
		 * charset=utf-8 Transfer-Encoding=chunked Connection=keep-alive
		 * X-Powered-By=Express Access-Control-Allow-Origin=*
		 * Etag=W/"406-ut0vzoCuidvyMf8arZpMpJ6ZRDw" Via=1.1 vegur
		 * Cache-Control=max-age=14400 CF-Cache-Status=HIT Age=2612
		 * Expect-CT=max-age=604800,
		 * report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"
		 * Report-To={"endpoints":[{"url":
		 * "https:\/\/a.nel.cloudflare.com\/report\/v3?s=DkJtQiQzyPKR%2Fp7Nuas4fV%2BieGnyAlOBdfbu8HC0GCoKVOu%2BD6PnfbcRvYKs9UVOKbmsBfqbsRfdTo877ajxaT40geYRSVnDGE%2BFLj6dQnc%2BSqEx5hfAft8nFA%3D%3D"
		 * }],"group":"cf-nel","max_age":604800}
		 * NEL={"success_fraction":0,"report_to":"cf-nel","max_age":604800}
		 * Vary=Accept-Encoding Server=cloudflare CF-RAY=721f5a2bcef3793b-AMD
		 * Content-Encoding=gzip
		 * 
		 * 
		 */
		
		System.out.println(response.getHeader("Content-Encoding"));  //gzip
		
		Assert.assertEquals(response.getStatusCode(), 201);   //  

	}

}
