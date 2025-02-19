package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver ldriver) {

		this.driver = ldriver;
		PageFactory.initElements(driver, this);


	}

	//List<WebElement> items = driver.findElements(By.className("inventory_item"));

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

			/*for (WebElement item : items) {
				WebElement addToCartButton = item.findElement(By.xpath("//button[text='Add to Cart']"));
				addToCartButton.click();
			}
		}*/
        try {
            backpack.click();
            bikeLight.click();
            tShirt.click();
            fleeceJacket.click();
            oneSie.click();
            tshirtRed.click();
        } catch (NullPointerException e) {
			System.out.println("Add To cart Failed" +e);
        }

    }

	public void goTocart(){

        try {
            cart.click();
        } catch (NullPointerException e) {
			System.out.println("Element not Found" +e);
        }

    }
}
