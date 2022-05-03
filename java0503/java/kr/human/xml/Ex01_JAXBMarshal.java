package kr.human.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kr.human.json.vo.PersonVO;

public class Ex01_JAXBMarshal {
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("src/main/resources/personVO.xml")) {
			// 1. JAXB context객체 생성 : 클래스 타입을 인수로 지정
			JAXBContext context = JAXBContext.newInstance(PersonVO.class);
			
			// 2. 자바객체를 XML로 변경하는 객체  생성
			Marshaller m = context.createMarshaller();
			// 3. XML 의 모양지정
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 4. 화면에 출력
			PersonVO vo = new PersonVO("한사람", 22, true,new Date());
			m.marshal(vo, System.out);
			// 5. 파일로 저장
			m.marshal(vo, fw);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
