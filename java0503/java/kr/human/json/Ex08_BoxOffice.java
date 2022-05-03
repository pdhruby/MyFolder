package kr.human.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Ex08_BoxOffice {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		String urlAddress = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		urlAddress += "?key=f5eef3421c602c6cb7ea224104795888";
		urlAddress += "&targetDt=20220502";
		
		try {
			URL url = new URL(urlAddress);
			InputStreamReader isr = new InputStreamReader(url.openStream());
	
			// VO없이 JsonObject로 읽기
			JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
			System.out.println(jsonObject);
			JsonObject object = jsonObject.get("boxOfficeResult").getAsJsonObject();
			System.out.println(object.get("boxofficeType").getAsString());
			System.out.println(object.get("showRange").getAsString());
			JsonArray jsonArray = object.get("dailyBoxOfficeList").getAsJsonArray();
			for(JsonElement e : jsonArray) {
				JsonObject obj = e.getAsJsonObject();
				System.out.print(obj.get("rank").getAsInt() + " : ");
				System.out.print(obj.get("movieNm").getAsString());
				System.out.println("(" + obj.get("openDt").getAsString() + ")");
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
