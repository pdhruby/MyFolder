package kr.human.selenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Selenium 4는 Chrome v75이상과 호환
//Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.
public class Ex02 {
	public static void main(String[] args) {
		// 1.웹 드라이버의 경로를 지정해 준다.
		System.setProperty("webdriver.chrome.driver", new File("src/main/java/resources/chromedriver.exe").getAbsolutePath());
		
		// 2.Selenium으로 브라우져 열기
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		
		// 원하는 주소로 이동
		driver.get("https://www.naver.com");
		//브라우져를 최대화 시켜보자
		driver.manage().window().maximize();
		//암시적 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); // 0.5초 대기
		// name속성의 값이 query인 요 소를 찾자
		WebElement searchBox = driver.findElement(By.name("query"));
		// 문자열을 보낸다.
		searchBox.sendKeys("Selenium");
		// 검색버튼을 찾는다.
		WebElement searchBtn = driver.findElement(By.id("search_btn"));
		// 찾은 버튼을 클릭한다.
		searchBtn.click();
		
		//대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		
		String title = driver.getTitle();
		System.out.println("제목 : " + title);
		
		System.out.println(driver.findElement(By.id("nx_query")).getAttribute("placeholder"));
		
		// 3.Selenium으로 브라우져 닫기
		//driver.quit();
		
	
	
	
	
	}
}
