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

public class OMSFunctional {
	
	WebDriver driver;
	WebDriverWait wait;
	pages.MainPage mainPage = new pages.MainPage(driver);
	pages.LoginPage loginPage = new pages.LoginPage(driver);
	pages.ProductDetailsPage productPage = new pages.ProductDetailsPage(driver);
	String rmShop, email, password;
	
	@Test
  	public void SearchResultsSKU() {
		//Search for a random oms product
		utilities.OMSProduct.RandomProduct();
		String sku = utilities.OMSProduct.sku;
		String name = utilities.OMSProduct.name;
		//Search for product by sku
		pages.MainPage.productSearch(sku);
		//Wait for search results to be visible
		wait.until(ExpectedConditions
			.visibilityOfElementLocated((By
					.xpath("//*[@id=\"productsList\"]/ul/li/a"))));
		//Re-initialise elements
		mainPage = new pages.MainPage(driver);
		WebElement results = mainPage.firstResult;
		String actualResult = results.getText();
		String expectedResult = name;
		  
		try {
			Assert.assertEquals(actualResult, expectedResult);
			} catch (AssertionError e) {
				System.out.println("SearchResultsSKU --- Expected " + 
						expectedResult + ", but got " + actualResult + 
			    			", using sku: " + sku);
			    throw e;
			}
		}
	
	@Test
  	public void SearchResultsName() {
		//Search for a random oms product
		utilities.OMSProduct.RandomProduct();
		String sku = utilities.OMSProduct.sku;
		String name = utilities.OMSProduct.name;
		//Search for product by sku
		pages.MainPage.productSearch(name);
		//Wait for search results to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"productsList\"]/ul/li/a"))));
		//Re-initialise elements
		mainPage = new pages.MainPage(driver);
		WebElement results = mainPage.firstResult;
		String actualResult = results.getText();
		String expectedResult = name;
		  
		try {
			Assert.assertEquals(actualResult, expectedResult);
			} catch (AssertionError e) {
				System.out.println("SearchResultsName --- Expected \"" + 
						expectedResult + "\", but got \"" + actualResult + 
			    			"\", using sku: " + sku);
			    throw e;
			}
		}
	
	@Test
  	public void SearchResultGoToProduct() {
		//Search for a random oms product
		utilities.OMSProduct.RandomProduct();
		String sku = utilities.OMSProduct.sku;
		String name = utilities.OMSProduct.name;
		//Search for product by sku
		pages.MainPage.productSearch(sku);
		//Wait for search results to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"productsList\"]/ul/li/a"))));
		//Re-initialise elements
		mainPage = new pages.MainPage(driver);
		//Click the first result
		mainPage.firstResult.click();
		//initialise product page
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("qty"))));
		productPage = new pages.ProductDetailsPage(driver);
		WebElement results = pages.ProductDetailsPage.productNameText;
		//verify correct product page
		String actualResult = results.getText();
		String expectedResult = name;
		  
		try {
			Assert.assertTrue(actualResult.contains(expectedResult));
			} catch (AssertionError e) {
				System.out.println("SearchResultGoToProduct --- Expected " + 
						expectedResult + ", but got " + actualResult + 
			    			", using sku: " + sku);
			    throw e;
			}
		}
	

	
	@Parameters({"browser", "environment"})
  
	@BeforeMethod
	public void setUp(String browser, String environment) {
		//Define Environment URLs
		String url = utilities.Environments.getEnvironment(environment);
		rmShop = url;
		//Initiate driver & mainPage
		utilities.DriverFactory.open(browser);
		driver = utilities.DriverFactory.driver;
		driver.get(rmShop);
		//Initialise web elements
		mainPage = new pages.MainPage(driver);
		//Wait for page to load
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
		//Login as OMS User
		mainPage.clickAccount();
		//Wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-submit")));
		//Login as OMS user
		loginPage = new pages.LoginPage(driver);
		loginPage.login("oms");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
