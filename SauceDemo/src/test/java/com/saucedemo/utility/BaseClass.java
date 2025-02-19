package com.saucedemo.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {

    public WebDriver driver;

    public ConfigDataProvider config;

    public ExtentReports report;

    public ExcelDataProvider excel;

    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite(){

        Reporter.log("Starting the test execution",true);

        excel=new ExcelDataProvider();
        config = new ConfigDataProvider();

        ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/"+Helper.getCurrentDateTime()+"TestReport.html"));
        report = new ExtentReports();
        report.attachReporter(extent);

        Reporter.log("Setting Done. Test can be started",true);

    }

    @BeforeClass
    public void setup() {

        Reporter.log("Starting Browser and Application",true);

        driver = BrowserFactory.startBrowser(driver,config.getUrl());

        Reporter.log("Browser and Application started",true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            BrowserFactory.quitBrowser(driver);
        }
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {

        Reporter.log("Test is about to end.",true);

        if(result.getStatus() == ITestResult.FAILURE){
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
        }
        else if(result.getStatus()== ITestResult.SUCCESS){
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
        }
        else if(result.getStatus()== ITestResult.SKIP){
            logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
        }
        report.flush();

        Reporter.log("Test Completed and Report Generated!",true);
    }
}
