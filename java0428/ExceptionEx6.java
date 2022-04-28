package kr.human.java0428;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionEx6 {
	public static void main(String[] args) {
		//외부 자원에 접근할때는 예외 처리가 필수이다.
		Scanner sc = null;
		try {
			 sc = new Scanner(new File("src/main/resources/song.txt"));
			 while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
	
}
