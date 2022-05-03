package kr.human.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kr.human.json.Rss;

public class Ex04_JAXBMarshal2 {
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("src/main/resources/personVO.xml")) {
			URL url = new URL("https://rss.hankyung.com/feed/it.xml");
			// 1. JAXB context객체 생성 : 클래스 타입을 인수로 지정
			JAXBContext context = JAXBContext.newInstance(Rss.class);
			
			// 2. 자바객체를 XML로 변경하는 객체  생성
			Marshaller m = context.createMarshaller();
			Unmarshaller um = context.createUnmarshaller();
			// 3. XML 의 모양지정
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			InputStreamReader isr = new InputStreamReader(url.openStream());
			Rss rss = (Rss) um.unmarshal(isr);
			
			
			//제목 출력
			System.out.println(rss.getChannel().getTitle());
			System.out.println(rss.getChannel().getLink());
			System.out.println(rss.getChannel().getLastBuildDate());
		
			//기사출력
			for(Rss.Item item : rss.getChannel().getItem()) {
				System.out.println(item.getTitle() + " : "+item.getLink());
			}
			
			//파일로 저장
			m.marshal(rss, fw);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
