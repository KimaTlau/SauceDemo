package com.saucedemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutOverviewPage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public CheckoutOverviewPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//*[@id=\"finish\"]")
	WebElement finishButton;


	public void finishOrder() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(finishButton));
            finishButton.click();
        } catch (Exception e) {
			System.out.println("Over Time - Not Found" +e.getMessage());
        }

    }
}
