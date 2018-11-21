package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	
	WebDriver driver;
	//Expected Title
	public String expectedTitle = "Royal Mail | Shop";
	// RM Logo Top Left Corner
	@FindBy(css = ".logo") 
	public WebElement logoButton;
	
	//Account Button
	@FindBy(xpath="/html/body/div[2]/header/div[1]/ul/li/a")
		public WebElement accountButton;
	
	//Account Button after login
	@FindBy(xpath="/html/body/div[2]/header/div[1]/ul/li/span")
		public WebElement customerButton;
	//Basket Icon
	
	@FindBy(css=".showcart") public WebElement basketButton;
	//Search Bar
	@FindBy(id="search") public static WebElement searchBar;
	//Results Dropdown block
	@FindBy(id="klevuResultsBlock") public WebElement resultsBlock;
	//Result Products
	@FindBy(id="productsList") public WebElement productsList;
	//First Result
	@FindBy (xpath="//*[@id=\"productsList\"]/ul/li/a/div[2]/div[2]")
		public static WebElement firstResult;
	//OMS Category (only visible once logged in as OMS user)
	@FindBy(css=".v-navigation__link--url-online-mail-supplies")
		public WebElement omsCategory;
	//Cookies accept message close button
	@FindBy(id="btn-cookie-allow") public WebElement closeCookiesButton;
	
	
	
	public void clickLogo() {
		logoButton.click();
	}
	
	public void clickAccount() {
		accountButton.click();
	}
	
	public void clickBasket() {
		basketButton.click();
	}
	
	public static void productSearch(String product, WebDriver driver) {
		searchBar.clear();
		searchBar.sendKeys(product);
		//Wait for first search result to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"productsList\"]/ul/li[1]")));
	}
	
	public static void selectSearchResults(String product, Integer result, WebDriver driver) {
		//Search for string in search bar
		productSearch(product, driver);
		//List all result web elements
		List<WebElement> childs = driver.findElements(By.xpath("//*[@id=\"productsList\"]/ul/*"));
		//The third search result would be the second element in the list
		int i = result - 1;
		//Click the selected search result
		childs.get(i).click();
	}
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	

}
