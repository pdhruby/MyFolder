package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import kr.human.json.vo.ItemVo;

public class Ex09_JsonFileRead {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try(FileReader fr = new FileReader("src/main/resources/json.json")){
			ItemVo vo = gson.fromJson(fr, ItemVo.class);
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			for(ItemVo.History h : vo.getHistory()) {
				System.out.println(h.getItem() + " : " + h.getDate());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
