package PageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utils.WaitUtils;

public class ScrollPage {
	private WebDriver driver;
	
	public ScrollPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private final By Hometitle = By.xpath("//h1[contains(text(),'Practice Page')]");
	private final By listValue = By.cssSelector("[class='mouse-hover-content']");
	private final By alertElement = By.id("confirmbtn");
	
	public void ScrollDown() {
		
		WaitUtils.presentElement(driver, Hometitle);
		WebElement mouseHover = driver.findElement(By.id("mousehover"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mouseHover);
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).perform();
		
		 List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'mouse-hover-content')]/a"));
		 for(WebElement opt : options) {
			 opt.getText().equals("Top");
			 opt.click();
			 break;
		 }
	}

	public void alertChecking() {
		
		WaitUtils.presentElement(driver, alertElement);
		driver.findElement(alertElement).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
}
