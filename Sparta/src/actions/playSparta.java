package actions;

import org.openqa.selenium.WebDriver;

public class playSparta {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		String email, pwd;
		email = "abc";
		pwd = "12";
		utilities.DriverFactory.open("");
		driver = utilities.DriverFactory.driver;
		
		String url = utilities.ConfigFileReader.getEnvironmentURL("prod");
		driver.get(url);
		
		pages.loginForm loginform = new pages.loginForm(driver);
		System.out.println(url);
		loginform.login(email, pwd);


	}

}
