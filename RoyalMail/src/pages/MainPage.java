package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	WebDriver driver;
	//Expected Title
	public String expectedTitle = "Royal Mail | Shop";
	// RM Logo Top Left Corner
	@FindBy(css = ".logo") public WebElement logoButton;
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
		public WebElement firstResult;
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
	
	public static void productSearch(String product) {
		searchBar.sendKeys(product);
	}
	
	public void selectSearchResults(String product, Integer result) {
		productSearch(product);
		//List<WebElement> childs = rootWebElement.findElements(By.xpath(".//*"));
		///html/body/div[2]/header/div[1]/div[1]/div[2]/form/div[1]/div/div[2]/div[3]/div[3]/div[2]/ul/li[2]
		
	}
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	

}
