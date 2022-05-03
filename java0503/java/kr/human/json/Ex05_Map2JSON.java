package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

// Map을 JSON 형식으로 만들기
public class Ex05_Map2JSON {
	public static void main(String[] args) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "한사람");
		map.put("age", false);
		map.put("gender", true);
		map.put("date", LocalDate.now());
		
		System.out.println(map);
		System.out.println(gson.toJson(map));
		// Map JSON파일로 저장하기
		try(PrintWriter pw = new PrintWriter("src/main/resources/map.json")){
			gson.toJson(map, pw); // (객체, 출력스트림)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// JSON파일을 자바 객체로 읽기
		try(FileReader fr = new FileReader("src/main/resources/map.json")){
			Map<String, Object> map2 = gson.fromJson(fr, Map.class);
			System.out.println("읽은값 : " + map2 );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
