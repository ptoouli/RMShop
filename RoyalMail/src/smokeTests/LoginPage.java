package smokeTests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginPage {
	
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	pages.LoginPage loginPage = new pages.LoginPage(driver);
	String rmShop, email, password;
	
	@Test
	public void normalUserLogin() {
		//Login as Normal User
		mainPage.clickAccount();
		loginPage.login("normal");
		// Check Account button isn't there
		mainPage = new pages.MainPage(driver);
		String customerText = mainPage.customerButton.getText();
		Assert.assertFalse(customerText.contains("Account"));
		//and instead it has been renamed to "Hi customer"
		Assert.assertTrue(customerText.contains("Hi"));
	}
	
	@Test
	public void omsUserLogin() {
		//Login as OMS User
		mainPage.clickAccount();
		loginPage.login("oms");
		// Check Account button isn't there
		mainPage = new pages.MainPage(driver);
		String customerText = mainPage.customerButton.getText();
		Assert.assertFalse(customerText.contains("Account"));
		//and instead it has been renamed to "Hi customer"
		Assert.assertTrue(customerText.contains("Hi"));
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
		loginPage = new pages.LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
