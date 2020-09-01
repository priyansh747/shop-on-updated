package com.ShopOn.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.Utilities.PropertyFile;
import com.ShopOn.Utilities.ReadExcel;
import com.ShopOn.Utilities.ScreenShot;

import com.relevantcodes.extentreports.LogStatus;

@RunWith(Parameterized.class)
public class ChangePasswordTest1  extends BaseTest{
	
	private String newPass;
	private String currentPass;
	private static String password="qwerty";
	
	public ChangePasswordTest1(String currentPass,String newPass) {
	  
	  this.currentPass=currentPass;
	  this.newPass=newPass;
	  
	  }
	 
	
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("InValid Details TestCase");
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
	
	
	
	  @Parameterized.Parameters
	  
	  public static Collection testdata() throws IOException{ 
		  System.out.println("yo");
		  ReadExcel excel=new ReadExcel(new PropertyFile().get("screenshotsFolderPath").replace("/", "\\\\")+"ChangePasswordData.xlsx","Sheet1");
	  //excel.ReadSheet(excel.setExcelSheet());
		  int row=excel.getRowCount();
		  int lastcell=excel.lastCell();
		  Object [][] data=new Object[row][2];
	
		  for(int i=1;i<=row;i++) {
			  for(int j=1;j<lastcell;j++) {
				  data[i-1][j-1]=excel.readCellData(i, j);
		}
		
		
	}
  
  return Arrays.asList(data);
	  
	  
	  
	  
	  
	  
	  }
	 
	  
	  
	
	
	@Test
	public void ChangePasswordUsingValidExistingPassword() throws Exception {
		
		LoginPage objlogin = new LoginPage(super.driver);

		objlogin.setUserName("qwerty1");

		objlogin.setPassword(password);
		driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
		Thread.sleep(1000);
		
		//driver.findElement(By.id("genericLogin-button")).click();
		//Thread.sleep(1000);
		objlogin.clickSubmit();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/ul/li[3]/a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/div/div[2]")));
		WebElement currentPassword=driver.findElement(By.id("currentPassword"));
		currentPassword.sendKeys(currentPass);
		WebElement newPassword=driver.findElement(By.id("password"));
		newPassword.sendKeys(newPass);
		WebElement newPasswordVerify=driver.findElement(By.id("checkPassword"));
		newPasswordVerify.sendKeys(newPass);
		System.out.println(newPass);
		password=newPass;
		System.out.println(password);
		WebElement submit=driver.findElement(By.id("submitChangePassword"));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		
		try {
		if(driver.findElement(By.id("password.errors")).isDisplayed()) {
		
		String actual=driver.findElement(By.id("password.errors")).getText();
		String expected="Invalid password";
		if(expected.contentEquals(actual)) {
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
			
		}
		}
		}
		
		
		catch(Exception e) {
			ScreenShot ss=new ScreenShot(super.driver,"ChangePasswordUsingValidExistingPassword");
			//ss.cleanFolder();
			ss.capture();
			
			//System.out.println(ss.getScreenshotName("ChangePasswordUsingValidExistingPassword").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("ChangePasswordUsingValidExistingPassword").replace("/", "\\\\"))+ "Test Failed");
			////ss.capture();
			//System.out.println(ss.getScreenshotName("ChangePasswordUsingValidExistingPassword").replace("/", "\\\\"));
			fail();
			
			
		}
		
		
		
		
	}
	

}
