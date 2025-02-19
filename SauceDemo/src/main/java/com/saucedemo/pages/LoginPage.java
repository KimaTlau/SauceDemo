package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "user-name")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	public void loginToSauceDemo(String username, String pass) {


        try {
            userName.sendKeys(username);
            passWord.sendKeys(pass);
            loginButton.click();
        } catch (NullPointerException e) {
            System.out.println("Login Failed" +e);
        }

    }
}
