package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private static final int DEFAULT_TIMEOUT=30;
	public static WebElement WaitForVisible(WebDriver driver,By element) {
		 return new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public static WebElement WaitForClickable(WebDriver driver,By element) {
		 return new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
	}
	public static Boolean waitForPageLoad(WebDriver driver,String url) {
		return new WebDriverWait(driver,Duration.ofSeconds(40)).until(ExpectedConditions.urlContains(url));
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * wait.until(webDriver -> ((JavascriptExecutor) webDriver)
		 * .executeScript("return document.readyState").equals("complete"));
		 */
	}
	public static WebElement presentElement(WebDriver driver,By element) {
		return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(element));
	}

	
}
