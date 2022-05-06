package kr.human.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Selenium 4는 Chrome v75이상과 호환
//Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.
public class Ex01 {
	public static void main(String[] args) {
		// 1.웹 드라이버의 경로를 지정해 준다.
		System.setProperty("webdriver.chrome.driver", new File("src/main/resources/chromedriver.exe").getAbsolutePath());
		
		// 2.Selenium으로 브라우져 열기
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		// 3.Selenium으로 브라우져 닫기
		driver.quit();
		
	
	
	
	
	}
}
