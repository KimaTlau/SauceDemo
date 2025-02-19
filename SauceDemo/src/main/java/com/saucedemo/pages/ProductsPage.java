package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage {

	WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public ProductsPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);


	}

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement backpack;

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
	WebElement bikeLight;

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
	WebElement tShirt;

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
	WebElement fleeceJacket;

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
	WebElement oneSie;

	@FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
	WebElement tshirtRed;

	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	WebElement cart;


	public void addtoCart() {

        try {

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(backpack));
            backpack.click();

			wait.until(ExpectedConditions.visibilityOf(bikeLight));
            bikeLight.click();

			wait.until(ExpectedConditions.visibilityOf(tShirt));
            tShirt.click();

			wait.until(ExpectedConditions.visibilityOf(fleeceJacket));
            fleeceJacket.click();

			wait.until(ExpectedConditions.visibilityOf(oneSie));
            oneSie.click();

			wait.until(ExpectedConditions.visibilityOf(tshirtRed));
            tshirtRed.click();
        } catch (Exception e) {
			System.out.println("Over Time - Add To cart Failed" +e.getMessage());
        }

    }

	public void goTocart(){

        try {

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(cart));
            cart.click();
        } catch (Exception e) {
			System.out.println("Over Time - Element not Found" +e.getMessage());
        }

    }
}
