package com.saucedemo.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Helper {

    public static String captureScreenShot(WebDriver driver) {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String screenShotPath = System.getProperty("user.dir")+"/Screenshots/"+getCurrentDateTime()+"screenshot.png";

        try {
            FileHandler.copy(src, new File(screenShotPath));
        } catch (Exception e) {
           System.out.println("Not able to capture screenshot" +e.getMessage());
        }

        return screenShotPath;
    }

    public static String getCurrentDateTime(){

        DateFormat customFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date date = new Date();
        return customFormat.format(date);

    }
}
