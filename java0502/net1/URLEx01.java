package kr.human.net1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLEx01 {
	public static void main(String[] args) {
		String urlAddress = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=jsp";

		try {
			URL url = new URL(urlAddress);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());

			System.out.println("네이버 소스보기!!!");
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
