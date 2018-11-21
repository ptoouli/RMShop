package tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MainPage;

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
		MainPage.searchBar.sendKeys("MBG"); 
	}
	
	
	@Parameters({"browser", "environment", "runHeadless"})
	
	@BeforeMethod
	public void setUp(String browser, String environment, Boolean runHeadless) {
		//Define Environment URLs
		String url = utilities.Environments.getEnvironment(environment);
		rmShop = url;
		//Initiate driver & mainPage
		utilities.DriverFactory.open(browser, runHeadless);
		driver = utilities.DriverFactory.driver;
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
