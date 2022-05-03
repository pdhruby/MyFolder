package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.human.json.vo.BibleNameVO;

// Map을 JSON 형식으로 만들기
public class Ex06_Map2JSON2 {
	public static void main(String[] args) {
		Gson gson = new Gson();

		// JSON파일을 자바 Map 객체로 읽기
		try(FileReader fr = new FileReader("src/main/resources/bible_name.json")){
			Map<String, Object>[] mapArray = gson.fromJson(fr, Map[].class);
			for(Map<String,Object> map : mapArray) {
				System.out.println(map);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-".repeat(40));
		
		// JSON파일을 자바 VO 객체로 읽기
		try(FileReader fr = new FileReader("src/main/resources/bible_name.json")){
			BibleNameVO[] voArray = gson.fromJson(fr, BibleNameVO[].class);
			for(BibleNameVO vo : voArray) {
				System.out.println(vo.getK() + "(" + vo.getE() +")");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
		// JSON파일을 자바 VO 객체로 읽기
		try(FileReader fr = new FileReader("src/main/resources/bible_name.json")){
			JsonArray jsonArray = gson.fromJson(fr, JsonArray.class);
			System.out.println(jsonArray.size() + "개");
			
			for(JsonElement e : jsonArray) {
//				System.out.println(e);
				JsonObject obj = (JsonObject)e;
				System.out.println(obj.get("k").getAsString());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
	}
}
