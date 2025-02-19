package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutPage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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

			wait.until(ExpectedConditions.visibilityOf(firstName));
            firstName.sendKeys(fName);

			wait.until(ExpectedConditions.visibilityOf(lastName));
            lastName.sendKeys(lName);

			wait.until(ExpectedConditions.visibilityOf(postalCode));
            postalCode.sendKeys(zip);

        } catch (Exception e) {
			System.out.println("Over Time - Not able to enter details." +e.getMessage());
        }


    }

	public void checkoutConfirmation(){

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

        try {

			wait.until(ExpectedConditions.visibilityOf(continueButton));
            continueButton.click();
        } catch (Exception e) {
			System.out.println("Over Time - Element Not Found" +e.getMessage());
        }

    }
}
