package com.Amazon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Amazon.Baseclass;
import com.Amazon.SDP;

public class Amazon_Project extends Baseclass {
	WebDriver driver = null;
	String selectvalue = "baby";
	String searchProduct = "Soft Toys";
	SDP ss;
	
	

	@BeforeTest
	public void browser_Launch() {

		driver = browserlaunch("chrome");
		
	}
	
	
	@BeforeClass
	@SuppressWarnings("deprecation")
	public void url_Launch() {

		getUrl("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	
	@Test(priority = 0)
	public void drop_down() {
		SDP ss = new SDP(driver);

		Select alloptions = new Select(ss.getHomepage().getdropdownlist());

		List<WebElement> options2 = getOptions(ss.getHomepage().getdropdownlist());

		for (int i = 0; i < options2.size(); i++) {
			WebElement eachoption = options2.get(i);
			String eachtext = eachoption.getText();
			if (eachtext.equalsIgnoreCase(selectvalue)) {
				alloptions.selectByVisibleText(eachtext);

			}
		}
	}

	@Test(priority = 1)
	public void select() throws InterruptedException {
		 ss = new SDP(driver);
		
		sendKey(ss.getHomepage().getSearch(), searchProduct);
		sleep();

		List<WebElement> relevant = ss.getHomepage().getRelevant();
		for (int i = 1; i <= relevant.size(); i++) {
			WebElement findElement = driver
					.findElement(By.xpath("//div[@id='nav-flyout-searchAjax']/child::div/div[" + i + "]"));
			String textsearchProduct = getText(findElement);

			System.out.println(textsearchProduct);
			if (textsearchProduct.equalsIgnoreCase(searchProduct)) {

				click(findElement);
				break;

			}
		}

	}

	@Test(priority = 2)
	public void first_Product() {
		
		click(ss.getProduct_Page().getFOP());
	}

	@Test(priority = 3)
	public void window_handle() {

		String parentwindow = windowHandle();

		Set<String> windowHandles = multipleWindows();
		for (String string : windowHandles) {
			if (!string.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(string);
				break;
			}

//		String loadedtitle = getTitle();
	}}

	@Test(priority = 4)
	public void add_To_Cart() {

		click(ss.getAdd_To_Cart().getAddtocart());
	}

	@Test(priority = 5)
	public void cart_Checkout() throws InterruptedException {
		sleep();
		js_Click(ss.Check_Out().getCart());
		click(ss.Check_Out().getProceedtocheckout());

	}

	@Test(priority = 6)
	public void screenShot() throws InterruptedException, IOException {
		capture("Amazon");
	}

	@AfterTest
	public void close1() {
//	   driver.close();
	}
}
