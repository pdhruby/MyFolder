package kr.human.net1;

import java.io.IOException;
import java.util.Scanner;

// 자바에서 외부 프로그램 실행하기
public class RuntimeEx2 {
	public static void main(String[] args) {
		try {
			// JDK 1.4 이전
			Process process = Runtime.getRuntime().exec("cmd /c ipconfig"); // 메모장
			Scanner sc = new Scanner(process.getInputStream(), "MS949");
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
			sc.close();
			System.out.println("-".repeat(40));
			// JDK 1.5 이상
			ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","ipconfig");
			Process process2 = processBuilder.start();
			Scanner sc2 = new Scanner(process2.getInputStream(), "MS949");
			while(sc2.hasNextLine())
				System.out.println(sc2.nextLine());
			sc2.close();
			System.out.println("-".repeat(40));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
