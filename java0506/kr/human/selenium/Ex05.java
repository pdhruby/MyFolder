package kr.human.selenium;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ex05 {
	
	public static void main(String[] args) {
		// 현재 프로젝트의 절대 경로를 알아낸다.
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/java/resources/chromedriver.exe");
		log.debug(System.getProperty("user.dir")); // 현재 사용자의 위치를 알아낸다. 
		log.debug(path.toString()); // 크롬드라이버의 위치를 알아낸다.
		
		// 1. 웹드라이버의 경로를 지정해 주어야 한다.
		System.setProperty("webdriver.chrome.driver", path.toString());
		
		// 2. 웹드라이버의 옵션을 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");			// 전체화면으로 실행
		options.addArguments("--disable-popup-blocking");	// 팝업창 무시
		options.addArguments("--disable-default-apps");		// 기본앱 사용하지 않겠다.
		
		// 3. 웹드라이버 생성
		WebDriver driver = new ChromeDriver(options);
		
		//========================================================================================================
		// 4. 웹드라이버 사용
		String urlAddress = "https://www.naver.com";
		// 웹페이지 연결
		driver.get(urlAddress);
		
		// 다음과 같이 하면 캡차에 걸린다.
		// 요소 찾기 : 로그인 버튼 찾기
		WebElement loginBtn = driver.findElement(By.className("link_login"));
		loginBtn.click();
// 보안에 걸린다		
//		WebElement userid = driver.findElement(By.id("id"));
//		userid.sendKeys("userid");
//		WebElement password = driver.findElement(By.id("pw"));
//		password.sendKeys("password");
//		
		
		// 자바스크립트를 실행한다.
	      JavascriptExecutor js = (JavascriptExecutor) driver;  
	      js.executeScript("document.getElementById('id').value='';");
	      js.executeScript("document.getElementById('pw').value='';");
	      
	      WebElement submitBtn = driver.findElement(By.id("log.login"));
	      submitBtn.click();
	      
		//submitBtn.submit();
		//========================================================================================================
		/*
		// 5. 웹드라이버 닫기
		driver.close();
		
		// 6. 5초 후 웹드라이버 종료
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 웹드라이버 종료
			driver.quit();
		}
		*/
	}
}

