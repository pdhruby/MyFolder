package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOEx01 {
	public static void main(String[] args) {
		// 예전방식
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/main/resources/chunja2.txt");
			int n = 0;
			while((n=fis.read())>0) { // read() : 1Byte 읽는다. 리턴 타입 int타입 ,없으면 -1리턴
				System.out.println(n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
