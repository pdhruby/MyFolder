package kr.human.lunar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LunarUtil {

	
	// 년월을 입력받아 LunaVO리스트를 리턴하는 메서드를 만들자!!!
	
	
	public static List<LunarVO> getLunarDate(int year, int month){
		List<LunarVO> lunarList = null;
		
		String urlAddress="https://astro.kasi.re.kr/life/pageView/5";
		urlAddress += String.format("?search_year=%04d&search_month=%02d", year, month);
		// 문서 객체 얻기
		try {
			Document document = Jsoup.connect(urlAddress).get();
			Elements elements = document.select("table tbody tr");
			lunarList = new ArrayList<>();
			for(Element tr : elements) {
				Elements tds = tr.select("td");
				LunarVO vo = new LunarVO();
				vo.setSolar(tds.get(0).text());
				vo.setLunar(tds.get(1).text());
				vo.setGanji(tds.get(2).text());
				lunarList.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lunarList;
	}
	public static void main(String[] args) {
		List<LunarVO> lunarList = getLunarDate(2022,1);
		System.out.println(lunarList);
		
	}	
	

}
