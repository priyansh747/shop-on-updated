package com.ShopOn.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;




public class ChangePasswordTest extends BaseTest {
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("Valid Details TestCase");
	}
	
	public void setUp() {

		super.setUp();
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	
	
	@Test
	public void ChangePasswordUsingValidExistingPassword() throws Exception {
		
		LoginPage objlogin = new LoginPage(super.driver);

		objlogin.setUserName("qwerty1");

		objlogin.setPassword("qwerty");
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
		Thread.sleep(1000);
		objlogin.clickSubmit();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/ul/li[3]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/div/div[2]")));
		WebElement currentPassword=driver.findElement(By.id("currentPassword"));
		currentPassword.sendKeys("qwerty");
		WebElement newPassword=driver.findElement(By.id("password"));
		newPassword.sendKeys("qwerty");
		WebElement newPasswordVerify=driver.findElement(By.id("checkPassword"));
		newPasswordVerify.sendKeys("qwerty");
		WebElement submit=driver.findElement(By.id("submitChangePassword"));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		
		String actual=driver.findElement(By.id("store.success")).getText();
		String expected="Request completed with success";
		if(expected.contentEquals(actual)) {
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
			
		}
		
		else {
			ScreenShot ss=new ScreenShot(super.driver,"ChangePasswordUsingValidExistingPassword");
			ss.cleanFolder();
			ss.capture();
			
			System.out.println(ss.getScreenshotName("ChangePasswordUsingValidExistingPassword").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("ChangePasswordUsingValidExistingPassword").replace("/", "\\\\"))+ "Test Failed");
			ss.capture();
			System.out.println(ss.getScreenshotName("ChangePasswordUsingValidExistingPassword").replace("/", "\\\\"));
			fail();
			
			
		}
		
		
	}
	
	

}
