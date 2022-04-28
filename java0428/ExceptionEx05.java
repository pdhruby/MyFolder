package kr.human.java0428;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ExceptionEx05 {
	public static void main(String[] args) {
		//외부 자원에 접근할때는 예외 처리가 필수이다.
		Scanner sc = null;
		try {
			 sc = new Scanner(new URL("https://www.naver.com").openStream());
			 while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
	
}
