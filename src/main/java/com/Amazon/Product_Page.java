package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {

public static WebDriver driver;
	
	
	
	public Product_Page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	@FindBy (xpath="//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//span[@class='a-price']")
	private WebElement FOP;
	
	@FindBy (xpath="//span[text()='RESULTS']/ancestor::div[4]/following-sibling::div[1]//h2")
	private WebElement firstproduct;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getFOP() {
		return FOP;
	}

	public WebElement getFirstproduct() {
		return firstproduct;
	}
	
	
}
