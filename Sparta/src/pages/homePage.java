package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage
{
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"#root-element\"]/div/header/div/div[3]/div/div/button[1]")
	public WebElement loginButton;

	public void goToLogin()
	{
		loginButton.click();
		utilities.WaitForElement.xpath("/html/body/div[5]/div/div/div/form/button", driver);
	}
	
	public homePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
