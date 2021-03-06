package smokeTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductDetailsPage {
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	String rmShop;

	
	@Test
	public void alwaysFails() {
		//Check RM Logo is Visible
		pages.MainPage.selectSearchResults("s", 1, driver);
		Assert.assertEquals("1", "0");
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
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
