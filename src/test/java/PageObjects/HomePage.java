package PageObjects;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Tests.BaseTest;
import Utils.ExcelReader;
import Utils.WaitUtils;
import io.qameta.allure.Step;

public class HomePage  {
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private final By logo =  By.cssSelector("img[title='Flipkart']");
	
	private final By searchBox =  By.name("q");

	private final By home =  By.xpath("//a[contains(text(),'Home')]");
	
	private final By searchIcon =  By.xpath("//button[@class='kV1UjG']");
	
	

	@Step("Enter product name")
	public void searchField(String excelFileName, String sheetname, int row, int col) throws Exception {
		WaitUtils.WaitForClickable(driver, searchBox);
		String product = ExcelReader.ExcelSheetAccess(excelFileName, sheetname, row, col);
		enterProductName(product).clickSearchOption();
	}


	private HomePage clickSearchOption() {
		driver.findElement(searchIcon).sendKeys(Keys.TAB);
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
		return this;
	}


	private HomePage enterProductName(String product) {
		
		driver.findElement(searchBox).sendKeys(product);
		return this;
	}


	public void homeLoadCheck() {
		WaitUtils.WaitForVisible(driver, logo);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(home)).perform();
		
	}
}
