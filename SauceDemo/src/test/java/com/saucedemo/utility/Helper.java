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

    public static void captureScreenShot(WebDriver driver) {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(src, new File("src/Screenshots/"+getCurrentDateTime()+"screenshot.png"));
        } catch (Exception e) {
           System.out.println("Not able to capture screenshot" +e.getMessage());
        }
    }

    public static String getCurrentDateTime(){

        DateFormat customFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date date = new Date();
        return customFormat.format(date);

    }
}
