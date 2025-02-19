package com.saucedemo.testcases;

import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.saucedemo.utility.BrowserFactory;

public class LoginToPage {

	WebDriver driver;


	@Test
	public void login() {

		driver = BrowserFactory.startBrowser(driver,"https://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(driver);

        //LoginPage loginPage = new LoginPage(driver);

		loginPage.loginToSauceDemo("standard_user", "secret_sauce");



		BrowserFactory.quitBrowser(driver);
	}

}
