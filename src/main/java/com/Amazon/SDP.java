package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SDP {
	public static WebDriver driver;
	private Add_To_Cart ac;
	private Product_Page pp;
	private Homepage h;
	private Check_Out co;
	

	
	
	public SDP(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}
	
	public Product_Page getProduct_Page() {
		
		if(pp==null) {
		pp=new Product_Page(driver);
		}
		return pp;
		
	}
	public Homepage getHomepage() {
		
		if(h==null) {
		h=new Homepage(driver);
		}
		return h;
		
	}
	public Check_Out Check_Out() {
		
		if(co==null) {
		co=new Check_Out(driver);
		}
		return co;
		
	}

	public Add_To_Cart getAdd_To_Cart() {
		
		if(ac==null) {
		ac=new Add_To_Cart(driver);
		}
		return ac;
		
	}
	


}
