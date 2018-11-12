package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver open(String browserType, String driverLocation) {
		
		switch (browserType) {
		case "firefox":	
			System.setProperty("webdriver.gecko.driver", driverLocation + "geckodriver.exe");
			return new FirefoxDriver();
		case "edge":
			System.setProperty("webdriver.edge.driver", driverLocation + "MicrosoftWebDriver.exe");
			return new EdgeDriver();
		case "headless":
			System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            return new ChromeDriver(options);
            
       default:
    	   	System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
			return new ChromeDriver();
		}
		
	}

}
