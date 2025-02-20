package com.saucedemo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


import static org.testng.Assert.assertEquals;

public class SauceDemo2 {

	@Test
	public void Test() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");

        WebElement userName = null;
        WebElement passWord = null;
        WebElement loginButton = null;
        try {
            userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            passWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        } catch (Exception e) {
            System.out.println("Over Time" +e.getMessage());
        }


        userName.sendKeys("standard_user");
		passWord.sendKeys("secret_sauce");
		loginButton.click();


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
