package com.saucedemo.testcases;

import com.saucedemo.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.saucedemo.utility.BrowserFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.AssertJUnit.assertEquals;

public class LoginToPage {

	WebDriver driver;


	@Test
	public void loginAndCheckout() {

		driver = BrowserFactory.startBrowser(driver,"https://www.saucedemo.com/");

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

		assertEquals(headerMessage,"Thank you for your order!");

		checkoutCompletePage.backHome();

		BrowserFactory.quitBrowser(driver);
	}

}
