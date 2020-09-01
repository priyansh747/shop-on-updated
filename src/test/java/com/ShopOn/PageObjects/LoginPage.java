package com.ShopOn.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ShopOn.BasePage.BasePage;

public class LoginPage extends BasePage {
		
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="signin_userName")
	WebElement username;
	
	@FindBy(id="signin_password")
	WebElement password;
	
	@FindBy(id="genericLogin-button")
	WebElement submit;
	
	public void setUserName(String strUserName){
		username.sendKeys(strUserName);
	}
	
	public void setPassword(String strPassword){
		password.sendKeys(strPassword);
	}
	
	public void checkifloginbuttonpresent(){
		
	}
	
	public void clickSubmit(){ 

		submit.click(); 

		} 
	
}
