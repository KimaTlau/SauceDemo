package com.saucedemo.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

	public static WebDriver startBrowser(WebDriver driver, String url) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);



		driver.manage().window().maximize();

		driver.get(url);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();

	}

}
