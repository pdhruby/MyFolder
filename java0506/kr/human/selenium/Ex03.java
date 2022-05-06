package kr.human.selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Selenium 4는 Chrome v75이상과 호환 
// Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.
public class Ex03 {
	public static void main(String[] args) {
		// 1. 웹드라이버의 경로를 지정해 준다.
		System.setProperty("webdriver.chrome.driver", 
				new File("src/main/java/resources/chromedriver.exe").getAbsolutePath());
		
		// 2. Selenium으로 브라우져 열기
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		// 원하는 주소로 이동
		driver.get("http://www.event-tv.co.kr/core/newsninfo/festivarbooklet");
		// 브라우져를 최대화 시켜보자
		driver.manage().window().maximize();
		// 암시적 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); // 0.5초 대기

		//  화면 전체를 스크린샷을 찍어보자
		try {
			File fullScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg;
			fullImg = ImageIO.read(fullScreenShot);
			ImageIO.write(fullImg, "png" , new FileOutputStream("full.png"));

			// 화면 일부를 스크린샷을 찍어보자
			WebElement element = driver.findElement(By.id("content"));
			String title = element.findElement(By.tagName("h2")).getText();
			System.out.println(title);
			File screenshot = element.getScreenshotAs(OutputType.FILE);
		
			BufferedImage  divImg = ImageIO.read(screenshot);
			ImageIO.write(divImg, "png" , new FileOutputStream("divimg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3. Selenium으로 브라우져 닫기
		driver.quit();
	}
}
