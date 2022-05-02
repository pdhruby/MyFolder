package kr.human.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx08 {
	public static void main(String[] args) {

		String urlAddress = "https://images.khan.co.kr/freecomics/3843/";

		try (FileOutputStream fos = new FileOutputStream("전륜마룡2부.html");) {
			for (int i = 1; i <= 36; i++) {
				for (int j = 1; j <= 58; j++) {
					fos.write(("<img src='" + urlAddress + String.format("%03d/%03d.jpg",i, j) + "'>\n").getBytes());
					fos.flush();
				}
			}
			System.out.println("저장완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
