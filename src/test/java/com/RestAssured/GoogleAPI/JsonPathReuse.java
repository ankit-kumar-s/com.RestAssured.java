package com.RestAssured.GoogleAPI;

import io.restassured.path.json.JsonPath;

public class JsonPathReuse {
	
	public static JsonPath rawtoJson(String response) {
		
		JsonPath js = new JsonPath(response);
		return js;
	}

}
