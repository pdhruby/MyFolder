package kr.human.java0502;
//Properties : <String , String>인 맵이다.

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx01 {
	public static void main(String[] args) {
		Properties properties = new Properties();
		//추가
		properties.setProperty("db", "Oracle");
		properties.setProperty("dbuser", "system");
		properties.setProperty("dbpassword", "system123");
		//읽기
		System.out.println(properties.getProperty("db"));
		System.out.println(properties.getProperty("dbuser"));
		System.out.println(properties.getProperty("dbpassword"));
		
		//파일로 저장하기
		try {
			// store은 .프로퍼티로 저장 / storeToXML은 .xml로 저장된다.
			properties.store(new FileWriter("db.properties"),"데이터베이스 사용자 정보");
			properties.storeToXML(new FileOutputStream("db.xml"),"데이터베이스 사용자 정보");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
