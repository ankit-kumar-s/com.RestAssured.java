package com.RestAssured.Library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBookRequest {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type","application/json").body(BodyRequest.addlibrary()).when().post("Library/Addbook.php")
				.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
	String id=	js.getString("ID");
    System.out.println(id);
	}

}
