package kr.human.json;

import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.human.json.vo.PersonVO;

public class Ex03_Object2JSON2 {
	public static void main(String[] args) {
		// 자바 기본타입을 JSON형식으로 만들기
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		//toJson : json 문자열로 만든다.
		System.out.println(gson.toJson(123));
		System.out.println(gson.toJson(123.456));
		System.out.println(gson.toJson(true));
		System.out.println(gson.toJson("한사람"));
		System.out.println(gson.toJson("한놈,두식이,석삼,너구리,오징어".split(",")));
	
		// json형식의 문자열을 자바 자료형으로 만들기
		int num = gson.fromJson("123", int.class); //; (json문자열, 읽을타입)
		double d = gson.fromJson("3.14", double.class);
		boolean b = gson.fromJson("false", boolean.class);
		String str = gson.fromJson("한사람",String.class);
		int[] ar = gson.fromJson("[1,2,3,4,5,6,7,8,9]", int[].class);
		System.out.println(Arrays.toString(ar));
		
		str = "{\"name\": \"한사람\",\"age\": 24,\"gender\": false }";
		PersonVO vo = gson.fromJson(str, PersonVO.class);
		System.out.println(vo);
	

		
	}
}
