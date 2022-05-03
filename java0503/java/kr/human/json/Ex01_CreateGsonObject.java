package kr.human.json;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Ex01_CreateGsonObject {
	public static void main(String[] args) {
		// JsonObject 객체 생성 방법
		JsonObject jsonObject = new JsonObject();
		// Property추가
		jsonObject.addProperty("name", "한사람");
		jsonObject.addProperty("age", 22);
		jsonObject.addProperty("gender", true);
		jsonObject.addProperty("date", LocalDate.now().toString());
		
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
		
		// 1. new Gson()
		Gson gson = new Gson();
		System.out.println(gson.toJson(jsonObject));
		
		// new GsonBuilder()을 이용하여 Gson 객체를 생성하면, 몇 가지 옵션을 추가해서 객체를 생성할 수 있습니다.
		// 2. new GsonBuilder().create()
		Gson gson2 = new GsonBuilder().create();
		System.out.println(gson2.toJson(jsonObject));
		
		// 3. new GsonBuilder().setPrettyPrinting().create()
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson3.toJson(jsonObject));
	}
}