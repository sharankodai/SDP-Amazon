package com.Amazon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {


	public static WebDriver driver;
	
	public Homepage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy (xpath="//select[@aria-describedby='searchDropdownDescription']")
	private WebElement dropdownlist;
	
	@FindBy (id="twotabsearchtextbox")
	private WebElement search;
	
	@FindBy (xpath="//div[@id='nav-flyout-searchAjax']/child::div")
	private List<WebElement> relevant;
	
	@FindBy(xpath="//div[@id='nav-flyout-searchAjax']/child::div/div[\" + i + \"]")
	private WebElement findElement;


	
	
	

	public WebElement getFindElement() {
		return findElement;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getdropdownlist() {
		return dropdownlist;
	}

	public WebElement getSearch() {
		return search;
	}

	public List<WebElement> getRelevant() {
		return relevant;
	}

}


