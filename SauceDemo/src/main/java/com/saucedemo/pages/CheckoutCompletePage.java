package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutCompletePage {

	WebDriver driver;

	public CheckoutCompletePage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//h2[@data-test=\"complete-header\"]")
	WebElement header;
	
	@FindBy(xpath = "//*[@id=\"back-to-products\"]")
	WebElement homeButton;
	
	String headerMessage;


	public String getHeaderMessage() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}


        try {
            headerMessage = header.getText();
        } catch (Exception e) {
			System.out.println("Not Found" +e);
        }

        return headerMessage;

	}
	
	public void backHome() {

        try {
            homeButton.click();
        } catch (Exception e) {
			System.out.println("Not Found" +e);
        }

    }
}
