package com.JsonComplex;

import io.restassured.path.json.JsonPath;

public class WorkingonComplexJson {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(ComplexJsonParse.jsonbody());
		
	int count =	js.getInt("courses.size()");
		System.out.println(count);
		
		int totalamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		
		String title =js.get("courses[2].title");
	System.out.println(title);
	}

}
