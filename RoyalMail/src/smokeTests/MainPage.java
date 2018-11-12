package smokeTests;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPage {
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	String rmPage, rmLogin, loginURL, checkoutPage, rmShop;
	
	@Test
	public void mainpageLogoPresent() {
		//Check RM Logo is Visible
		Assert.assertTrue(mainPage.logoButton.isDisplayed());
	}
	@Test
	public void mainpageAccountPresent() {
		//Check Account is Visible
		Assert.assertTrue(mainPage.accountButton.isDisplayed());
		//and says account
		String accountText = mainPage.accountButton.getText();
		Assert.assertTrue(accountText.contains("Account"));
	}
	@Test
	public void mainpageBasketPresent() {
		//Check Basket is Visible
		Assert.assertTrue(mainPage.basketButton.isDisplayed());
		//and nothing in the basket
		String basketCounter = mainPage.basketButton.getText();
		Assert.assertTrue(basketCounter.contains("Basket"));
	}
	@Test
	public void searchBarPresent() {
		Assert.assertTrue(mainPage.searchBar.isDisplayed());
	}
	@Test
	public void resultsBlockPresent() {
		mainPage.searchBar.sendKeys("s");
		Assert.assertTrue(mainPage.resultsBlock.isDisplayed());
	}
		
		
		
	@Test
	public void mainpageTitleCorrect() {
		//Check Title is correct
		Assert.assertTrue(driver.getTitle().equals(mainPage.expectedTitle));
	}
	
	@Test
	public void LogoCorrectDestination() throws InterruptedException {
		//Check Logo goes to RM Main page
		Assert.assertEquals(mainPage.logoButton.getAttribute("href"), rmPage, "Logo not going to " + rmPage);
		mainPage.clickLogo();
		Assert.assertEquals(driver.getCurrentUrl(), rmPage);
	}
	@Test
	public void AccountCorrectDestination() {
		//Check My Account goes to login page 
		Assert.assertEquals(mainPage.accountButton.getAttribute("href"), rmLogin);
		mainPage.clickAccount();
		//with redirect
		loginURL = driver.getCurrentUrl();
		Assert.assertTrue(loginURL.contains("user/login"));
		Assert.assertTrue(loginURL.contains("?goto=https%3A%2F%2Fidp.royalmailgroup.com"));
		Assert.assertTrue(loginURL.contains("SAML"));
	}
	@Test
	public void BasketCorrectDestination() {
		//Check Basket goes to Checkout
		Assert.assertEquals(mainPage.basketButton.getAttribute("href"), checkoutPage);
		mainPage.clickBasket();
		Assert.assertEquals(driver.getCurrentUrl(),checkoutPage);
	}
	
	@Parameters({"browser", "environment", "driverLocation"})
	
	
	@BeforeMethod
	public void setUp(String browser, String environment, String driverLocation) {
		//Define Environment URLs
		List<String> urls = utilities.Environments.setEnvironment(environment);
		rmPage = urls.get(0);
		rmShop = urls.get(1);
		rmLogin = rmShop + "customer/account/login/";
		checkoutPage = rmShop + "checkout/cart/";
		//Initiate driver & mainPage
		driver = utilities.DriverFactory.open(browser, driverLocation);
		driver.get(rmShop);
		//Initialise web elements
		mainPage = new pages.MainPage(driver);

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
