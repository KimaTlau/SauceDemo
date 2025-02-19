package com.saucedemo.testcases;

import com.saucedemo.pages.*;
import com.saucedemo.utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.saucedemo.utility.BrowserFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.AssertJUnit.assertEquals;

public class LoginToPage {

	WebDriver driver;

	@Test
	public void loginAndCheckout() {

		driver = BrowserFactory.startBrowser("https://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartpage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

		loginPage.loginToSauceDemo("standard_user", "secret_sauce");

		productsPage.addtoCart();

		productsPage.goTocart();

		cartpage.checkout();

		checkoutPage.enterDetails("John", "Doe", "12345");

		checkoutPage.checkoutConfirmation();

		checkoutOverviewPage.finishOrder();

		String headerMessage = checkoutCompletePage.getHeaderMessage();

		System.out.println("Message: " +headerMessage);

		assertEquals("Thank you for your order!", headerMessage);

		checkoutCompletePage.backHome();

		BrowserFactory.quitBrowser(driver);

		System.out.println("Test Completed!");
	}

}
