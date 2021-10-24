package restApi;

import java.util.HashMap;

import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRes {

	public GetRes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		RestAssured.baseURI = "https://gorest.co.in/public/v1/users";
		RequestSpecification request = RestAssured.given();
		request.header("ContentType", "application/json");
		request.header("Authorization", "Bearer 51c59bd6d919f51467b735c87b414c498266e2ae99cf5b749dd9c47d6d4643ac");

		Response response = request.get();
		System.out.println("Status Line : " + response.getStatusLine());

		// System.out.println("Response : " + response.prettyPrint());
		System.out.println(response.jsonPath().get("meta.pagination"));
		System.out.println("Page : " + response.jsonPath().get("meta.pagination.links.next"));
		String next = response.jsonPath().get("meta.pagination.links.next");
		System.out.println("Result : " + response.jsonPath().get("data[0,1]"));
		response = request.get(next);
		//response.prettyPrint();
		System.out.println("Page : " + response.jsonPath().get("meta.pagination.links.next"));
		System.out.println("Result : " + response.jsonPath().get("data[0,1]"));


	}

}
