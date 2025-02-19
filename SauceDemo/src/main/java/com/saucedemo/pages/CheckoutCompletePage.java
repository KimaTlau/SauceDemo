package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutCompletePage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public CheckoutCompletePage(WebDriver ldriver) {

        this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[@data-test=\"complete-header\"]")
	WebElement headerElement;
	
	@FindBy(xpath = "//*[@id=\"back-to-products\"]")
	WebElement homeButton;
	
	String headerMessage;


	public String getHeaderMessage() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}


        try {

			wait.until(ExpectedConditions.visibilityOf(headerElement));
            headerMessage = headerElement.getText();
        } catch (Exception e) {
			System.out.println("Over Time - Element Not Found" +e.getMessage());
        }

        return headerMessage;

	}
	
	public void backHome() {

        try {

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(homeButton));
            homeButton.click();
        } catch (Exception e) {
			System.out.println("Over Time - Element Not Found" +e.getMessage());
        }

    }
}
