package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

import utilities.ConfigFileReader;

public class TestListener implements ITestListener {
	
	ConfigFileReader configFileReader = new ConfigFileReader();
	String rootPath = configFileReader.getDefectScreenshot();
	WebDriver driver;
	
	@Override
	public void onTestFailure(ITestResult result) {

    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName = result.getName().toString().trim();
    	String[] reqname = result.getTestClass().toString().trim().split("\\.");
    	int i = reqname.length - 1;
    	String className = reqname[i].substring(0, reqname[i].length() - 1);
    	driver = utilities.DriverFactory.driver;
    	takeScreenShot(methodName, className, driver);
    }
    
    public void takeScreenShot(String methodName, String className, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
            	String filePath = rootPath + className + "\\";
            	System.out.println(filePath);
            	new File(filePath).mkdir();
            	String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
				Files.copy(scrFile, new File(filePath + timeStamp + methodName + ".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {
    }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
	}
