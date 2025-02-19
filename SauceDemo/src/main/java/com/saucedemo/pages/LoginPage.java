package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(id = "login-button")
	WebElement loginButton;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	public void loginToSauceDemo(String username, String pass) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		try {

			wait.until(ExpectedConditions.visibilityOf(userName));
            userName.sendKeys(username);

			wait.until(ExpectedConditions.visibilityOf(passWord));
            passWord.sendKeys(pass);

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(loginButton));
            loginButton.click();
        } catch ( Exception e) {
            System.out.println("Over Time - Login Failed: " +e.getMessage());
        }

    }
}
