package kr.human.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataSave {
	public static void main(String[] args) {
		//객체가 저장될때는 인스턴스 변수만 저장된다.
		// static 변수나 메서드는 저장되지 않는다. 모든 객체가 공유하므로 저장할 필요가 없다
		DataVO vo = new DataVO("문자열",1234);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data3.dat"))){
			oos.writeObject(vo);
			oos.flush();
			System.out.println("저장완료!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
