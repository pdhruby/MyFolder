package kr.human.selenium;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// 기본적으로 Selenium 4는 Chrome v75 이상과 호환됩니다. Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.

/*
왜 우리는 셀레늄을 기다릴 필요가 있습니까?
대부분의 웹 애플리케이션은 Ajax와 Javascript를 사용하여 개발되었습니다. 
페이지가 브라우저에 의해로드 될 때 상호 작용하려는 요소는 다른 시간 간격으로로드 될 수 있습니다.
요소 식별이 어려울뿐 아니라 요소가 없으면 " ElementNotVisibleException"예외가 발생합니다. Waits를 사용하여이 문제를 해결할 수 있습니다.
 */
public class Ex04 {
	public static void main(String[] args) {

		// 1. 웹드라이버의 경로를 지정해 주어야 한다.
		System.setProperty("webdriver.chrome.driver", new File("src/main/java/resources/chromedriver.exe").getAbsolutePath());
		
		// 2. Selenium으로 브라우저 열기
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // 전체화면으로 실행
		options.addArguments("--disable-popup-blocking"); // 팝업 무시
		options.addArguments("--disable-default-apps"); // 기본앱 사용안함
		options.addArguments("--headless"); // Browser를 띄우지 않음
		WebDriver driver = new ChromeDriver(options);

		// 기본 URL로 리디렉션합니다.
		driver.get("http://www.event-tv.co.kr/core/newsninfo/festivarbooklet" );

		// 암시 적 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		WebElement element = driver.findElement(By.id("content"));
		System.out.println(element.getText() + "\n" + "-".repeat(100));
		
		List<WebElement> divs = element.findElements(By.tagName("div"));
		System.out.println(divs.size() + "개" + "\n" + "-".repeat(100));
		
		List<WebElement> ps = divs.get(0).findElements(By.tagName("p"));

		System.out.println(ps.get(0).findElement(By.cssSelector("img")).getAttribute("src"));
		System.out.println(ps.get(0).findElement(By.cssSelector("img")).getAttribute("alt"));
		
		System.out.println(ps.get(1).findElement(By.cssSelector("img")).getAttribute("src"));
		System.out.println(ps.get(1).findElement(By.cssSelector("img")).getAttribute("alt"));
		System.out.println("-".repeat(100));
		List<WebElement> areas = ps.get(0).findElements(By.cssSelector("map area"));
		System.out.println("영역 : " + areas.size() + "개");
		for(WebElement e : areas) {
			if(!e.getAttribute("alt").equals("undefined")) {
				System.out.print(e.getAttribute("alt") + " : ");
				System.out.print(e.getAttribute("key") + " : ");
				System.out.println(e.getAttribute("img"));
			}
		}
		System.out.println("-".repeat(100));
		
		List<WebElement> areas2 = ps.get(1).findElements(By.cssSelector("map area"));
		System.out.println("영역 : " + areas2.size() + "개");
		for(WebElement e : areas2) {
			if(!e.getAttribute("alt").equals("undefined")) {
				System.out.print(e.getAttribute("alt") + " : ");
				System.out.print(e.getAttribute("code") + " : ");
				System.out.println(e.getAttribute("selimg"));
			}
		}
		System.out.println("-".repeat(100));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		// 3. Selenium으로 브라우저 닫기(세션종료)
		driver.quit();
	}
}

