package kr.human.net1;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx01 {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("음력을 보고싶은 년월을 입력하시오.");
			int year = sc.nextInt();
			int month = sc.nextInt();
			
			Document doc = Jsoup.connect("https://astro.kasi.re.kr/life/pageView/5" 
		                        + String.format("?search_year=%04d&search_month=%02d", year, month)).get();

			Elements elements = doc.select("table tbody tr");
			System.out.println(elements.size() + "개");

			for (Element e : elements) {
				Elements tds = e.select("td");
				System.out.println("양력 : " + tds.get(0).text() + "(" +tds.get(1).text()+") : " + tds.get(2).text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
