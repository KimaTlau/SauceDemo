package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutCompletePage {

	WebDriver driver;

	public CheckoutCompletePage(WebDriver ldriver) {

        this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-test='complete-header']")));
*/


	@FindBy(xpath = "//h2[@data-test=\"complete-header\"]")
	WebElement headerElement;
	
	@FindBy(xpath = "//*[@id=\"back-to-products\"]")
	WebElement homeButton;
	
	String headerMessage;


	public String getHeaderMessage() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}


        try {
            headerMessage = headerElement.getText();
        } catch (Exception e) {
			System.out.println("Not Found" +e.getMessage());
        }

        return headerMessage;

	}
	
	public void backHome() {

        try {
            homeButton.click();
        } catch (Exception e) {
			System.out.println("Not Found" +e.getMessage());
        }

    }
}
