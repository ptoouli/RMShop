package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OMSVisiblity {
	
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	pages.LoginPage loginPage = new pages.LoginPage(driver);
	String rmShop, email, password;
	
	@Test
	public void omsCategoryVisible() {
		//oms Category is not visible before logging in
		boolean omsCatVisible = utilities.ElementChecker.isElementDisplayed(mainPage.omsCategory);
		Assert.assertFalse(omsCatVisible);
		//Login as OMS User
		mainPage.clickAccount();
		loginPage.login("oms");
		mainPage = new pages.MainPage(driver);
		//Verify omsCategory is visible to OMS user
		Assert.assertTrue(mainPage.omsCategory.isDisplayed());
		}
	
	@Test
	public void omsCategoryNotVisible() {
		//oms Category is not visible before logging in
		boolean omsCatVisible = utilities.ElementChecker.isElementDisplayed(mainPage.omsCategory);
		Assert.assertFalse(omsCatVisible);
		//Login as Normal User
		mainPage.clickAccount();
		loginPage.login("normal");
		mainPage = new pages.MainPage(driver);
		omsCatVisible = utilities.ElementChecker.isElementDisplayed(mainPage.omsCategory);
		Assert.assertFalse(omsCatVisible);
		}
	
	@Test
	public void omsProductVisible() {
		//Login as OMS User
		mainPage.clickAccount();
		loginPage.login("oms");
		mainPage = new pages.MainPage(driver);
		//Search for an OMS product
		mainPage.searchBar.sendKeys("MBG"); 
	}
	
	
	@Parameters({"browser", "environment", "driverLocation"})
	
	@BeforeMethod
	public void setUp(String browser, String environment, String driverLocation) {
		//Define Environment URLs
		List<String> urls = utilities.Environments.setEnvironment(environment);
		rmShop = urls.get(1);
		//Initiate driver & mainPage
		driver = utilities.DriverFactory.open(browser, driverLocation);
		driver.get(rmShop);
		//Initialise web elements
		mainPage = new pages.MainPage(driver);
		loginPage = new pages.LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
