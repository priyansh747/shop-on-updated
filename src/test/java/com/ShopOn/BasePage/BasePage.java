package com.ShopOn.BasePage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver ;

	public BasePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
