package kr.human.xml;

import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.human.json.vo.Tests;

public class Ex03_JAXBUnMarshal2 {
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("src/main/resources/test.xml")) {
			// 1. JAXB context객체 생성 : 클래스 타입을 인수로 지정
			JAXBContext context = JAXBContext.newInstance(Tests.class);
			
			// 2. XML을 자바객체로 변경하는 객체  생성
			Unmarshaller um = context.createUnmarshaller();
			// 3. 읽기
			Tests vo = (Tests) um.unmarshal(fr);
			
			// 4. 읽은 객체 출력
			System.out.println(vo);
			
			for(Tests.Test test : vo.getTest()) {
				System.out.println(test.getTestId() + " : " + test.getTestType()+test.getName());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
