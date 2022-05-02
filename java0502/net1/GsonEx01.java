package kr.human.net1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class GsonEx01 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try {
			//읽기
			DicVO[] dicVOs = gson.fromJson(new FileReader("src/main/resources/dic.json"), DicVO[].class);
			System.out.println(dicVOs.length + "개 읽음");
			
			for(DicVO vo : dicVOs) {
				System.out.println(vo.getH() + "(" + vo.getM() + "" + vo.getM1() +")");
			}
			//저장하기
			gson.toJson(dicVOs, new FileWriter("src/main/resources/dic_copy_json"));
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
