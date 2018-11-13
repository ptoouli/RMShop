package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver open(String browserType) {
		
		//Define driver folder path using config reader class
		ConfigFileReader configFileReader = new ConfigFileReader();
		String driverPath = configFileReader.getDriverPath();		
		
		
		//Define the driver to use based on the browserType TestNG parameter
		switch (browserType) {
		case "firefox":	
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			return new FirefoxDriver();
		case "edge":
			System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
			return new EdgeDriver();
		case "headless":
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            return new ChromeDriver(options);
            
       default:
    	   	System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			return new ChromeDriver();
		}
		
	}

}
