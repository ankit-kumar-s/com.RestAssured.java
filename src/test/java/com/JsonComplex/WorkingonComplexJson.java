package com.JsonComplex;

import io.restassured.path.json.JsonPath;

public class WorkingonComplexJson {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(ComplexJsonParse.jsonbody());
		
	int count =	js.getInt("courses.size()");
		System.out.println(count);
	
	}

}
