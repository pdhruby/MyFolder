package kr.human.java0502;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx02 {
	public static void main(String[] args) {
		Properties properties =new Properties();
		//파일을 읽어서 사용하자
		
		
		try {
			properties.loadFromXML(new FileInputStream("db.xml"));
			
			System.out.println(properties.get("admin"));
			System.out.println(properties.get("dbuser"));
			System.out.println(properties.get
					("dbpassword"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-".repeat(60));
		
		
		try {
			properties.load(new FileReader("db.properties"));
			
			System.out.println(properties.get("admin"));
			System.out.println(properties.get("dbuser"));
			System.out.println(properties.get("dbpassword"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

		
	}

}
