package com.saucedemo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement checkoutButton;

	public void checkout() {

        try {
            checkoutButton.click();
        } catch (NullPointerException e) {
			System.out.println("Not found" +e);
        }

    }
}
