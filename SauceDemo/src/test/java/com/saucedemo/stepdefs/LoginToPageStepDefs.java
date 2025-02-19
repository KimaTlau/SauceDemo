package com.saucedemo.stepdefs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.pages.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.saucedemo.utility.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class LoginToPageStepDefs extends BaseClass {


    ProductsPage products = new ProductsPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkout = new CheckoutPage(driver);
    CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
    CheckoutCompletePage complete = new CheckoutCompletePage(driver);

    @Given("I log into the SauceDemo application with valid credentials")
    public void logIntoApplication() {

        logger=report.createTest("Login to SauceDemo");

        loginPage.loginToSauceDemo(excel.getStringData("Login",1,0), excel.getStringData("Login",1,1));

        logger.pass("Login to SauceDemo application successful");
    }

    @When("I add all available items to the shopping cart")
    public void addItemsToCart() {

        products.addtoCart();

        logger.pass("Added all available items to the shopping cart");

    }

    @Given("I proceed to the checkout overview page")
    public void goToCart() {

        products.goTocart();
        cartPage.checkout();

        logger.pass("Checkout overview page displayed");

    }

    @Given("I enter valid contact details")
    public void enterDetails(){

        checkout.enterDetails(excel.getStringData("Login",1,2),excel.getStringData("Login",1,3),excel.getStringData("Login",1,4));

        checkout.checkoutConfirmation();

        logger.pass("Entered valid contact details");

    }

    @Given("I confirm my order details on the checkout review page")
    public void checkoutReview(){

        overview.finishOrder();

        logger.pass("Finish checkout");

    }

    @Then("I should be able to successfully complete the checkout")
    public void checkoutComplete(){

        String header = complete.getHeaderMessage();

        assertEquals(header,"Thank you for your order!");

        Helper.captureScreenShot(driver);

        complete.backHome();

        report.flush();

    }
}
