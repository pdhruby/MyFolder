package kr.human.xml;

import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.human.json.vo.boxOfficeResult;

public class weatherTest {
		public static void main(String[] args) {
			try(FileReader fr = new FileReader("src/main/resources/weather.xml")) {
				// 1. JAXB context객체 생성 : 클래스 타입을 인수로 지정
				JAXBContext context = JAXBContext.newInstance(boxOfficeResult.class);
				
				// 2. XML을 자바객체로 변경하는 객체  생성
				Unmarshaller um = context.createUnmarshaller();
				// 3. 읽기
				boxOfficeResult vo = (boxOfficeResult) um.unmarshal(fr);
				// 4. 읽은 객체 출력
				System.out.println(vo.getShowRange());
			} catch (JAXBException e) {
				e.printStackTrace();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}