package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.Data;

public class Ex11_JsonWebRead {
	@Data
	public static class CoinVO{
		private String id;
		private String symbol;
		private String name;
	}
	public static void main(String[] args) {
		String urlAddress = "https://raw.githubusercontent.com/lukechilds/coinlist/master/src/coins.json";
		Gson gson = new Gson();
		try(FileWriter fw = new FileWriter("src/main/resources/coinList.json")){
			URL url = new URL(urlAddress);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			// 배열을 List로 읽기 : 타입을 TypeToken을 이용해서 읽는다.
			List<CoinVO> coinList = gson.fromJson(isr, new TypeToken<List<CoinVO>>() {}.getType());
			System.out.println(coinList.size() + "개 읽음");
			gson.toJson(coinList, fw); // 파일로 저장
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
