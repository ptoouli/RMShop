package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MBG {
	
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	pages.LoginPage loginPage = new pages.LoginPage(driver);
	pages.ProductDetailsPage productPage = new pages.ProductDetailsPage(driver);
	String rmShop, email, password;

	
	@Test 
	public void MBGPage() {
		utilities.OMSProduct.specificProduct("MBG");
		String sku = utilities.OMSProduct.sku;
		//Search for product by sku
		pages.MainPage.productSearch(sku, driver);
		//Wait for search results to be visible
		utilities.WaitForElement.xpath("//*[@id=\"productsList\"]/ul/li/a", driver);
		//Re-initialise elements
		mainPage = new pages.MainPage(driver);
		//Click the first result
		mainPage.firstResult.click();
		//initialise product page
		productPage = new pages.ProductDetailsPage(driver);
		//Wait for page to load
		utilities.WaitForElement.id("product-options-wrapper", driver);
		//Check all of the MBG options are visible
		Assert.assertTrue(productPage.mbgOptionsWrapper.isDisplayed(), "MBG options wrapper is not visible");
		Assert.assertTrue(productPage.mbgOption1Radio.isDisplayed(), "MBG option1 is not visible");
		Assert.assertTrue(productPage.mbgOption2Radio.isDisplayed(), "MBG option2 is not visible");
		Assert.assertTrue(productPage.mbgOption3Radio.isDisplayed(), "MBG option3 is not visible");
		//Check the text box is NOT displayed before any option is selected
		Assert.assertFalse(productPage.mbgBox.isDisplayed(), "MBG Option 2 text box is visible without clicking option2");
		//Check the text box is displayed when option 2 is selected
		utilities.WaitForElement.clickable(productPage.mbgOption2Radio, driver);
		productPage.mbgOption2Radio.click();
		Assert.assertTrue(productPage.mbgBox.isDisplayed(), "MBG Option 2 text box is not visible");
		//Check the text box is not displayed when option 1 is select
		productPage.mbgOption1Radio.click();
		Assert.assertTrue(utilities.ElementChecker.isElementDisplayed(productPage.mbgBox), "MBG Option 2 text box is visible with Option 1");
		//Check the text box is not displayed when option 3 is select
		productPage.mbgOption3Radio.click();
		Assert.assertTrue(utilities.ElementChecker.isElementDisplayed(productPage.mbgBox), "MBG Option 2 text box is visible with Option 3");
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
		utilities.WaitForElement.css(".logo", driver);
		mainPage.closeCookiesButton.click();
		//Login as OMS User
		mainPage.clickAccount();
		//Wait for page to load
		utilities.WaitForElement.id("edit-submit", driver);
		//Login as OMS user
		loginPage = new pages.LoginPage(driver);
		loginPage.login("oms");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
