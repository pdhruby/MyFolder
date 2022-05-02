package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOEx03 {
	public static void main(String[] args) {
		// 최근방식 : 자동 닫기 // 파이널을 제거하고 트라이안에 넣어서 사용
		try(FileInputStream fis = new FileInputStream("src/main/resources/chunja2.txt"); ) {
			
			int n = 0;
			while((n=fis.read())>0) { // read() : 1Byte 읽는다. 리턴 타입 int타입 ,없으면 -1리턴
				System.out.println((char)n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();

		}
	}
}
