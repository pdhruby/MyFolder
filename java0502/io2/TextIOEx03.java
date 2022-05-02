package kr.human.io2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextIOEx03 {
	public static void main(String[] args) {
		
		try {
			// 파일 전체를 1개의 변수로 읽는다.
			String str = Files.readString(Paths.get("src/main/resources/chunja.txt"));
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//파일 전체를 byte배열로 읽는다.
			byte[] data = Files.readAllBytes(Paths.get("src/main/resources/chunja.txt"));
			System.out.println(new String(data));
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(60));
		
		
		
		try {
			//파일 전체를 list로 읽는다
			List<String> lines = Files.readAllLines(Paths.get("src/main/resources/chunja.txt"));
			System.out.println(lines.get(0));
			System.out.println(lines.get(lines.size()-1));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("-".repeat(60));
		
		try {
			Files.copy(Paths.get("src/main/resources/chunja.txt"), new FileOutputStream("chunja.bak"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
