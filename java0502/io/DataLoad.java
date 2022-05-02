package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataLoad {
	public static void main(String[] args) {
		//객체가 저장될때는 인스턴스 변수만 저장된다.
		// static 변수나 메서드는 저장되지 않는다. 모든 객체가 공유하므로 저장할 필요가 없다
		DataVO vo = new DataVO("문자열",1234);
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data3.dat"))){
			try {
				System.out.println(ois.readObject()); // 읽어서 출력
				System.out.println("읽기완료!!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 읽어서 출력
	
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}
