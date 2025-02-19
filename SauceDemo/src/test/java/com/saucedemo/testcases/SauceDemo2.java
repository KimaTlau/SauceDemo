package com.saucedemo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertEquals;

public class SauceDemo2 {

	@Test
	public void Test() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.of(30, ChronoUnit.SECONDS));

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		driver.manage().timeouts().implicitlyWait(Duration.of(30, ChronoUnit.SECONDS));

		WebElement userName = driver.findElement(By.id("user-name"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		userName.sendKeys("standard_user");
		passWord.sendKeys("secret_sauce");
		loginButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e){

		}

		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e){

		}

		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

		WebElement fName = driver.findElement(By.id("first-name"));
		WebElement lName = driver.findElement(By.id("last-name"));
		WebElement postalCode = driver.findElement(By.id("postal-code"));
		WebElement continueButton = driver.findElement(By.id("continue"));

		fName.sendKeys("Kima");
		lName.sendKeys("Tlau");
		postalCode.sendKeys("796701");

		continueButton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.id("finish")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		WebElement header = driver.findElement(By.xpath("//h2[@data-test=\"complete-header\"]"));

		String headerMessage = header.getText();

		assertEquals(headerMessage,"Thank you for your order!");


		System.out.println("Message: " +headerMessage);

		driver.findElement(By.id("back-to-products")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		driver.quit();


	}

}
