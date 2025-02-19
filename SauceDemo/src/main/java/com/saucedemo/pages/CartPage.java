package com.saucedemo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public CartPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement checkoutButton;

	public void checkout() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

        try {
			wait.until(ExpectedConditions.visibilityOf(checkoutButton));
            checkoutButton.click();
        } catch (Exception e) {
			System.out.println("Over Time - Element Not found" +e.getMessage());
        }

    }
}
