package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Ex10_JsonFileRead {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try(FileReader fr = new FileReader("src/main/resources/json.json")){
			JsonObject jsonObject = gson.fromJson(fr, JsonObject.class);
			System.out.println(jsonObject.get("id").getAsString());
			System.out.println(jsonObject.get("name").getAsString());
			JsonArray jsonArray = jsonObject.get("history").getAsJsonArray();
			for(JsonElement e : jsonArray) {
				System.out.print(e.getAsJsonObject().get("item").getAsString());
				System.out.println("("+ e.getAsJsonObject().get("date").getAsString() + ")");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
