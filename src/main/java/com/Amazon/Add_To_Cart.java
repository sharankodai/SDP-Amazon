package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_To_Cart {

public static WebDriver driver;

	public Add_To_Cart(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirst_pro_OP() {
		return first_pro_OP;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

	@FindBy(xpath="//div[@id='centerCol']/div[10]/div//div//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	private WebElement first_pro_OP;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addtocart;
}
