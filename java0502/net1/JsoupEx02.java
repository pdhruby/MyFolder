package kr.human.net1;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx02 {
	public static void main(String[] args) {
		String urlAddress = "http://huggiescomics.blogspot.com/2016/09/1_34.html";
		
		try {
			FileWriter fw = new FileWriter("슬램덩크1권.html");

			Document document = Jsoup.connect(urlAddress).get();
		
			Elements elements = document.select("div#post-body-961539150409341825 a");
			
			for(Element e : elements) {
				System.out.println(e.attr("href"));
				fw.write("<aimg src='"+e.attr("href")+"'>\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
