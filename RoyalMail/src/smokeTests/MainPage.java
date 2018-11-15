package smokeTests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPage {
	WebDriver driver;
	pages.MainPage mainPage = new pages.MainPage(driver);
	String rmLogin, loginURL, checkoutPage, rmShop;
	
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
		Assert.assertTrue(pages.MainPage.searchBar.isDisplayed());
	}
	@Test
	public void resultsBlockPresent() {
		pages.MainPage.searchBar.sendKeys("s");
		utilities.WaitForElement.id("klevuResultsBlock", driver);
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
		String rmPage = "https://www.royalmail.com/";
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
	
	@Parameters({"browser", "environment"})
	
	
	@BeforeMethod
	public void setUp(String browser, String environment) {
		//Define Environment URLs
		String url = utilities.Environments.getEnvironment(environment);
		rmShop = url;
		rmLogin = rmShop + "customer/account/login/";
		checkoutPage = rmShop + "checkout/cart/";
		//Initiate driver & mainPage
		utilities.DriverFactory.open(browser);
		driver = utilities.DriverFactory.driver;
		driver.get(rmShop);
		//Initialise web elements
		utilities.WaitForElement.css(".logo", driver);
		mainPage = new pages.MainPage(driver);

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
