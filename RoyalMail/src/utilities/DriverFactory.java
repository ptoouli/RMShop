package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static void open(String browserType, Boolean runHeadless) {
		
		//Define driver folder path using config reader class
		ConfigFileReader configFileReader = new ConfigFileReader();
		String driverPath = configFileReader.getDriverPath();

		ChromeOptions cOptions = new ChromeOptions();
		FirefoxOptions fOptions = new FirefoxOptions();
		
		//Define the driver to use based on the browserType TestNG parameter
		switch (browserType) 
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			
			if(runHeadless)
			{
				fOptions.setHeadless(true);
			}

			driver = new FirefoxDriver();
			
		case "edge":
			System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			
            if(runHeadless)
			{
                cOptions.addArguments("headless");
			}
            driver = new ChromeDriver(cOptions);
            
		case "opera":
			System.setProperty("webdriver.opera.driver", driverPath + "operadriver.exe");
			driver = new OperaDriver();
			
		default:
    	   	System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
		}
		
	}

}
