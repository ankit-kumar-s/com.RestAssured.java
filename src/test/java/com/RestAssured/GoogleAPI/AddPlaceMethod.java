package com.RestAssured.GoogleAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class AddPlaceMethod {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response= given().log().all().queryParam("key ","qaclick123").header("Content-Type","application/json").body(BodyRequest.sendbody())
				.when().post("maps/api/place/add/json").then().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=JsonPathReuse.rawtoJson(response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		String newAddress = "123 street , New";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
	String getplaceresponse =	given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123").when().get("maps/api/place/get/json").then().assertThat()
		.statusCode(200).extract().response().asString();
	
	JsonPath js1 =JsonPathReuse.rawtoJson(getplaceresponse);
	 String addres =  js1.getString("address");
		System.out.println(addres);
		Assert.assertEquals(addres,newAddress );
	}
}