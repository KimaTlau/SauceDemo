package com.saucedemo.stepdefs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.pages.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.saucedemo.utility.BrowserFactory;
import com.saucedemo.utility.ConfigDataProvider;
import com.saucedemo.utility.ExcelDataProvider;
import com.saucedemo.utility.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class LoginToPageStepDefs {

    private WebDriver driver;

    ExcelDataProvider excel = new ExcelDataProvider();

    ConfigDataProvider config = new ConfigDataProvider();

    ExtentReports report = new ExtentReports();

    ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/"+Helper.getCurrentDateTime()+"TestReport.html"));

    ExtentTest logger;

    ProductsPage products = new ProductsPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkout = new CheckoutPage(driver);
    CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
    CheckoutCompletePage complete = new CheckoutCompletePage(driver);

    @Before
    public void setup() {

        report.attachReporter(extent);
        driver = BrowserFactory.startBrowser(driver,config.getUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            BrowserFactory.quitBrowser(driver);
        }
    }

    @Given("I log into the SauceDemo application with valid credentials")
    public void logIntoApplication() {

        logger=report.createTest("Login to SauceDemo");

        loginPage.loginToSauceDemo(excel.getStringData("Login",1,0), excel.getStringData("Login",1,1));
    }

    @When("I add all available items to the shopping cart")
    public void addItemsToCart() {

        products.addtoCart();

    }

    @Given("I proceed to the checkout overview page")
    public void goToCart() {

        products.goTocart();
        cartPage.checkout();

    }

    @Given("I enter valid contact details")
    public void enterDetails(){

        checkout.enterDetails(excel.getStringData("Login",1,2),excel.getStringData("Login",1,3),excel.getStringData("Login",1,4));

        checkout.checkoutConfirmation();

    }

    @Given("I confirm my order details on the checkout review page")
    public void checkoutReview(){

        overview.finishOrder();

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
