package com.Amazon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
		
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
public static WebDriver driver;
	
	
	public static WebDriver browserlaunch(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("start-maximized");
			WebDriverManager.chromedriver().setup();
			
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("gecko")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid browser");
		}
		
		return driver;
	}
	public static void getUrl(String Url) {
		driver.get(Url);
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		boolean displayed = false;
		 try {
			displayed = element.isDisplayed();
		} catch (Exception e) {

			e.printStackTrace();
		}
		 return displayed;
			}
	
	public static boolean isElementEnabled(WebElement element) {
		boolean enabled=false;
		try {
			enabled =element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enabled;
	}
	

	
	public static void sendKey(WebElement element, String Value) {
		try {
			if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.sendKeys(Value);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	public void js_Click(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0], click();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void click(WebElement element) {
		try {
			if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.click();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
		
	}
	
	public static String getAttributePlaceHolder(WebElement element) {
		String attribute = element.getAttribute("placeholder");
		return attribute;
	}
	

	
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		
	}
	
	public static void close() {
		driver.close();
	}
	
	public static void implicit_wait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void quit() {
		driver.quit();
	}
	public static String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public static Set<String> multipleWindows() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public static void navigateUrl(String url) {
		driver.navigate().to(url);
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void navigateBack() {
		driver.navigate().back();		
	}
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	public static void fullscreen() {
		driver.manage().window().fullscreen();
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void mouseBasedAction(String option,WebDriver driver,WebElement element) {
		try {
			Actions a = new Actions (driver);
			if(option.equalsIgnoreCase("move")) {
				a.moveToElement(element).build().perform();
			}else if(option.equalsIgnoreCase("click")) {
				a.click(element).perform();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	public void scrollUsingElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0], scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void keyPress() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
	}
	public static void keyEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void acceptSendKeys_Alert(String option) {
		driver.switchTo().alert().sendKeys(option);
	}
	
	public static void alert(String option) {
		Alert alert = driver.switchTo().alert();
		if(option.equalsIgnoreCase("ok")) {
			alert.accept();
			driver.switchTo().defaultContent();
					}else if(option.equalsIgnoreCase("cancel")) {
						alert.dismiss();
						driver.switchTo().defaultContent();
					}
	}
	public static void switchtoFrame(WebElement element) {
		driver.switchTo().frame(element);
		
	}
	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;
	}
	
	public static void select(WebElement element,String option,String Value) {
		try {
			Select s = new Select(element);
			if(option.equalsIgnoreCase("value")) {
				s.selectByValue(Value);
			}else if(option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(Value);
			}else if(option.equalsIgnoreCase("index")) {
				int parseInt = Integer.parseInt(option);
				s.deselectByIndex(parseInt);
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static List<WebElement> getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}
	

	public static void capture(String pn) throws IOException {
		try {
			Date date = new Date();
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
			String format=d.format(date);
			String r=format.replaceAll("/", "-");		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\shara\\eclipse-workspace\\SDP_Amazon\\Screenshot\\"+pn+"_"+r+ ".png");
			FileUtils.copyFile(source, destination);
		} catch (WebDriverException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		

	}
//	public static void main(String[] args) {
//		Date date = new Date();
//		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
//		String format=d.format(date);
//		String r=format.replaceAll("/", "-");		
//	System.out.println(r);
//	}
	public void scrollUsingCoOrdinates(String width, String height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(" + width + "," + height + ")");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollToBottomOfthePage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollToTopOfThePage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void dragAndDrop(WebElement sourceElement, WebElement placedElement) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(sourceElement, placedElement);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}



