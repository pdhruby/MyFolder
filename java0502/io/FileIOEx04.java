package kr.human.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOEx04 {
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("test.txt");){
			fos.write("정말 저장이될까요?\n저장되지 않으면 낭패인데\n".getBytes());
			fos.flush(); // 버퍼의 내용을 저장해라.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
