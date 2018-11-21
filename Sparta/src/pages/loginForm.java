package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginForm extends homePage
{
	
	//@FindBy(name="email")
	public WebElement emailBox;
	
	@FindBy(id="password")
	public WebElement pwdBox;
	
	@FindBy(xpath="/html/body/div[5]/div/div/div/form/button")
	public WebElement playNowButton;

	public void inputEmail(String email)
	{
		emailBox = driver.findElement(By.name("email"));
		utilities.WaitForElement.elementVisible(emailBox, driver);
		emailBox.clear();
		emailBox.sendKeys(email);
	}
	
	public void inputPwd(String pwd)
	{
		pwdBox.clear();
		pwdBox.sendKeys(pwd);
	}
	
	public void login(String email, String pwd) throws InterruptedException
	{
		inputEmail(email);
		inputPwd(pwd);
		playNowButton.click();
	}
	
	public loginForm(WebDriver driver) {
		super(driver);
		goToLogin();
		PageFactory.initElements(driver, this);
	}

}
