package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;;

public class OMSCheckout {
	
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	pages.LoginPage loginPage = new pages.LoginPage(driver);
	String rmShop, email, password;
	
	@Test
  	public void SearchResults() {
	  utilities.OMSProductDetails.RandomProduct();
	  String sku = utilities.OMSProductDetails.sku;
	  String name = utilities.OMSProductDetails.name;
	  
	  pages.MainPage.productSearch(sku);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement element = wait.until(ExpectedConditions
			  .visibilityOfElementLocated((By.xpath("//*[@id=\"productsList\"]/ul/li/a"))));
	  mainPage = new pages.MainPage(driver);
	  WebElement results = mainPage.firstResult;
	  String actualResult = results.getText();
	  String expectedResult = name;
	  
	  try {
		  Assert.assertEquals(actualResult, expectedResult);
		} catch (AssertionError e) {
		    System.out.println("Expected " + 
		    		actualResult + ", but got " + expectedResult + 
		    		", using sku: " + sku);
		    throw e;
		}
	}
	
	@Test 
	public void MBGPage() {
		utilities.OMSProductDetails.specificProduct("MBG");
		  String sku = utilities.OMSProductDetails.sku;
		  String name = utilities.OMSProductDetails.name;
			System.out.println(sku);
			System.out.println(name);
		  
	}
	
	
	@Parameters({"browser", "environment"})
  
	@BeforeMethod
	public void setUp(String browser, String environment) {
		//Define Environment URLs
		List<String> urls = utilities.Environments.setEnvironment(environment);
		rmShop = urls.get(1);
		//Initiate driver & mainPage
		driver = utilities.DriverFactory.open(browser);
		driver.get(rmShop);
		//Initialise web elements
		mainPage = new pages.MainPage(driver);
		//Wait for page to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
		//Login as OMS User
		mainPage.clickAccount();
		//Wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-submit")));
		loginPage = new pages.LoginPage(driver);
		loginPage.login("oms");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
