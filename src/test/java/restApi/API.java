package restApi;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API {

	public API() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String rand = LocalTime.now().getHour() + "" + LocalTime.now().getMinute();
		API rapi = new API();
		String name, gender, status, email;
		name = "Ssat10".concat(rand);
		gender = "male";
		status = "active";
		email = name.concat("@email.com");
	int id = rapi.postRequest(name, gender, status, email);
		rapi.getResponseBody(4027);
		/*
		 * rapi.putRequest(id,name,email); rapi.getResponseBody(id);
		 * rapi.deleteRequest(id);
		 */
		// rapi.putRequest();
	}

	public void getResponseBody(int id) {
		RestAssured.baseURI = "https://gorest.co.in/public/v1/users";
		RequestSpecification request = RestAssured.given();
		request.header("ContentType", "application/json");
		request.header("Authorization", "Bearer 51c59bd6d919f51467b735c87b414c498266e2ae99cf5b749dd9c47d6d4643ac");

		Response response = request.get("/" + id);
		System.out.println("Status Line : " + response.getStatusLine());

		System.out.println("Response : " + response.body().asString());
		//HashMap<String, String> meta = response.jsonPath().get("meta.pagination.links");
	//	System.out.println("meta : " + meta.toString());
		JsonPath jp = response.jsonPath();
				System.out.println(" Result : "+jp.get("$data"));
		response.prettyPrint();

		/*
		 * List<HashMap<String, String>> la = jp.get("data");
		 * 
		 * Iterator<HashMap<String, String>> itr = la.iterator(); while (itr.hasNext())
		 * { HashMap<String, String> hm = itr.next(); Set<String> keys = hm.keySet();
		 * Iterator<String> it = keys.iterator(); while (it.hasNext()) { String key =
		 * it.next(); System.out.println(key + "	: " + String.valueOf(hm.get(key)));
		 * 
		 * } }
		 */

	}

	@SuppressWarnings("unchecked")
	public int postRequest(String name, String gender, String status, String email) {
		// POJO pj=new POJO("Satchi","Satchitest@email.com","male","active");
		RestAssured.baseURI = "https://gorest.co.in/public/v1/users";
		RequestSpecification request = RestAssured.given();
		// Map<String,String> request=new HashMap<String,String>();
		request.header("Accept", "application/json");
		request.header("ContentType", "application/json");
		request.header("Authorization", "Bearer 51c59bd6d919f51467b735c87b414c498266e2ae99cf5b749dd9c47d6d4643ac");
		JSONObject requestParams = new JSONObject();
		// json.put("id", "1301");
		requestParams.put("name", name);
		requestParams.put("gender", gender);
		requestParams.put("email", email);
		requestParams.put("status", status);
		// String
		// body="{\"gender\":\"male\",\"name\":\"Ssat621\",\"email\":\"ssat621@gmail.com\",\"status\":\"active\"}";
		// RestAssured.given().baseUri("https://gorest.co.in/public/v1/users").body(body).headers(request).relaxedHTTPSValidation().post().prettyPrint();

		request.body(requestParams.toString());
		Response response = request.post();
		response.prettyPrint();
		System.out.println("Post Status Code : "+response.statusCode());
		System.out.println("Post Status : "+response.statusLine());
		System.out.println("API Change");
		return response.jsonPath().get("data.id");

	}

	public void putRequest(int id, String name,String email) {
		// POJO pj=new POJO("Satchi","Satchitest@email.com","male","active");
		RestAssured.baseURI = "https://gorest.co.in/public/v1/users";
		RequestSpecification request = RestAssured.given();
		// Map<String,String> request=new HashMap<String,String>();
		request.header("Accept", "application/json");
		request.header("ContentType", "application/json");
		request.header("Authorization", "Bearer 51c59bd6d919f51467b735c87b414c498266e2ae99cf5b749dd9c47d6d4643ac");
		JSONObject requestParams = new JSONObject();
		// json.put("id", "1301");
		requestParams.put("name", name);
		//requestParams.put("gender", "male");
		requestParams.put("email", email);
		//requestParams.put("status", "active");
		// String
		// body="{\"gender\":\"male\",\"name\":\"Ssat621\",\"email\":\"ssat621@gmail.com\",\"status\":\"active\"}";
		// RestAssured.given().baseUri("https://gorest.co.in/public/v1/users").body(body).headers(request).relaxedHTTPSValidation().post().prettyPrint();

		request.body(requestParams.toString());
		Response response = request.put("/" + id);
		response.prettyPrint();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());

	}

	public void deleteRequest(int id) {
		RestAssured.baseURI = "https://gorest.co.in/public/v1/users";
		RequestSpecification request = RestAssured.given();
		request.header("ContentType", "application/json");
		request.header("Authorization", "51c59bd6d919f51467b735c87b414c498266e2ae99cf5b749dd9c47d6d4643ac");
		Response response = request.delete("/"+id);
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
	}
	
	}
