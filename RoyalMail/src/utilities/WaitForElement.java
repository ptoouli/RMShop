package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
	static WebDriverWait wait;
	
	public static void id(String id, WebDriver driver) {
	wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public static void css(String css, WebDriver driver) {
	wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
	}
	
	public static void xpath(String xpath, WebDriver driver) {
	wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static void clickable(WebElement element, WebDriver driver) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
