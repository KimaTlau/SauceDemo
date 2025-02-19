package com.saucedemo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserFactory {

	public static WebDriver startBrowser(String url) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));


		driver.manage().window().maximize();

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();

	}

}
