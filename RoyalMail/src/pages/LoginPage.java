package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	//Register Button
	@FindBy(css = "span.primary")
	public WebElement registerButton;
	
	//Email Address Box
	@FindBy(id = "edit-name")
	public WebElement emailBox;
	
	//Password Box
	@FindBy(id = "edit-pass")
	public WebElement pwdBox;
	
	//Login Button
	@FindBy(id = "edit-submit")
	public WebElement loginButton;

	
	public void login(String role) {
		
		List<String> loginDetails = utilities.UserRoles.loginDetails(role);
		String email = loginDetails.get(0);
		String password = loginDetails.get(1);
			
		emailBox.sendKeys(email);
		pwdBox.sendKeys(password);
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".logo"))));
	}
	
	public void register() {
		registerButton.click();
	}
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
