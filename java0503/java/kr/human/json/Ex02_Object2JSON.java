package kr.human.json;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.human.json.vo.PersonVO;

public class Ex02_Object2JSON {
	public static void main(String[] args) {
		PersonVO vo = new PersonVO("한사람", 24, false, new Date());
		System.out.println(vo);
		// 자바 객체를 JSON형식으로 만들기
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonStr = gson.toJson(vo);
		System.out.println(jsonStr);
	}
}
