package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Check_Out {

	public static WebDriver driver;

	public Check_Out(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']")
	private WebElement cart;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	private WebElement proceedtocheckout;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getProceedtocheckout() {
		return proceedtocheckout;
	}
	
	}
