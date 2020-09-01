package com.ShopOn.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	
	/*	private final static Logger log =  
    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); */
private WebDriver driver;	
private final String folderPath ;
private static int i;
private String methodName;
static {
	i=0;
}

private final String folderNotExistError = "screenshot folder does not exist";
private final String cannotCleanFolderError = "cannot clean screenshot folder";
private final String cannotCaptureScreenshotError = "cannot capture the screenshot";


public ScreenShot(WebDriver driver,String methodName) throws Exception {		
this.driver = driver;
this.methodName=methodName;
folderPath = new PropertyFile().get("screenshotsFolderPath");
File file =new File(folderPath+methodName+"/");
file.mkdir();
validateFolderExists();				
}

private void validateFolderExists() {
File screenShotFolder = new File(folderPath);
if (!screenShotFolder.exists()) {
	//log.info(folderNotExistError);
	throw new RuntimeException(folderNotExistError);
}
}

public void cleanFolder()
{		
try{					
	File screenShotFolder = new File(folderPath+methodName+"/");
	for(File file: screenShotFolder.listFiles()) 
		file.delete();
}
catch(Exception ex) {
	//log.info(cannotCleanFolderError);
	throw new RuntimeException(cannotCleanFolderError, ex);
}
}	

public void capture() 
{		
File scrFile;
 
 try {
	 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 i++;
	 FileUtils.copyFile(scrFile, new File(getScreenshotName(methodName)));
	 
	 return;
 } 
 catch (IOException e) {
	 e.printStackTrace();
 }
 
 //log.info(cannotCaptureScreenshotError);
 throw new RuntimeException(cannotCaptureScreenshotError);

}

public String getScreenshotName(String methodName) {
 String localDateTime = LocalDateTime.now().toString().replaceAll("[^0-9a-zA-Z]", "");
 StringBuilder name = new StringBuilder().append(folderPath+methodName+"/") 
		       							 .append(methodName)
		       							 .append(i)
		       							 .append(".png");
 
 System.out.println(name.toString());
 return name.toString();
}

}
