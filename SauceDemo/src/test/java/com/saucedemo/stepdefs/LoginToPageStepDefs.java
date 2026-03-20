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
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class LoginToPageStepDefs extends BaseClass {


    ProductsPage products;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkout;
    CheckoutOverviewPage overview;
    CheckoutCompletePage complete;

    @Before
    public void setupCucumber() {
        Reporter.log("Starting the test execution", true);
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();

        String reportPath = System.getProperty("user.dir") + "/Reports/" + Helper.getCurrentDateTime() + "TestReport.html";
        ExtentSparkReporter extentSpark = new ExtentSparkReporter(new File(reportPath));
        report = new ExtentReports();
        report.attachReporter(extentSpark);

        Reporter.log("Starting Browser and Application", true);
        driver = BrowserFactory.startBrowser(config.getUrl());
        Reporter.log("Browser and Application started", true);

        products = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        overview = new CheckoutOverviewPage(driver);
        complete = new CheckoutCompletePage(driver);
    }

    @After
    public void tearDownCucumber() {
        if (driver != null) {
            BrowserFactory.quitBrowser(driver);
        }
        if (report != null) {
            report.flush();
        }
    }

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

    @When("I proceed to the checkout overview page")
    public void goToCart() {

        products.goTocart();
        cartPage.checkout();

        logger.pass("Checkout overview page displayed");

    }

    @When("I enter valid contact details")
    public void enterDetails(){

        checkout.enterDetails(excel.getStringData("Login",1,2),excel.getStringData("Login",1,3),excel.getStringData("Login",1,4));

        checkout.checkoutConfirmation();

        logger.pass("Entered valid contact details");

    }

    @When("I confirm my order details on the checkout review page")
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

    }
}
