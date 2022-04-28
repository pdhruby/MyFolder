package kr.human.java0428;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// 사용자가 만드는 예외 클래스
class SectionnotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5682419874482256547L;

	public SectionnotFoundException(String message) {
		super(message);
		
	}
}

public class ExceptionEx7 {
	public static void main(String[] args) {
		//외부 자원에 접근할때는 예외 처리가 필수이다.
		//JDK 1.7부터 자동 닫기기능이 지원된다.
		try(Scanner sc = new Scanner(new URL("https://www.naver.com").openStream());) {
			 
			 while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			 }
			 throw new SectionnotFoundException("글이없네요!!!")
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
