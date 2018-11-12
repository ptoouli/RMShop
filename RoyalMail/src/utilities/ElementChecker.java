package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementChecker {

	WebDriver driver;
	
	public static boolean isElementDisplayed(WebElement element) {
	    try {
	        element.isDisplayed();
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

}
