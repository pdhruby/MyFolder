package kr.human.net1;

import java.io.IOException;

//자바에서 외부 프로그램 실행하기 
public class RuntimeEx {
	public static void main(String[] args) {
		try {
			// JDK 1.4이전 
//			Runtime.getRuntime().exec("notepad.exe"); // 메모장
//			Runtime.getRuntime().exec("mspaint.exe"); // 그림판
			
			// JDK 1.5이상
			ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
			processBuilder.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
