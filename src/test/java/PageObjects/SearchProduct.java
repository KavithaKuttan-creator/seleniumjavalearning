package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Tests.BaseTest;
import Utils.WaitUtils;






public class SearchProduct{

	
	private WebDriver driver;
	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}

	
	private final By result1 = By.xpath("(//div[contains(@class,'row')])[1]");
	
	private final By showText = By.xpath("(//div[contains(@class,'lvJbLV')])//span[contains(text(),'Showing')]");
	
	public void pageCorrectness() {
		
		//Assert.assertTrue(WaitUtils.waitForPageLoad(driver,"search"));
		WaitUtils.WaitForVisible(driver, showText);
			
		WaitUtils.WaitForClickable(driver, result1);
		driver.findElement(result1).click();
	
	
	}

}
