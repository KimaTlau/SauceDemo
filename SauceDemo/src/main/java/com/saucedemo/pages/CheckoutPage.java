package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;
	
	@FindBy(id = "continue")
	WebElement continueButton;

	public void enterDetails(String fName, String lName, String zip) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
        try {
            firstName.sendKeys(fName);
            lastName.sendKeys(lName);
            postalCode.sendKeys(zip);
        } catch (Exception e) {
			System.out.println("Not Found" +e);
        }


    }

	public void checkoutConfirmation(){

        try {
            continueButton.click();
        } catch (Exception e) {
			System.out.println("Not Found" +e);
        }

    }
}
