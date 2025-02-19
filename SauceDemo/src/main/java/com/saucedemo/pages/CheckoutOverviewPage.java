package com.saucedemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutOverviewPage {

	WebDriver driver;

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

            finishButton.click();
        } catch (Exception e) {
			System.out.println("Not Found" +e);
        }

    }
}
