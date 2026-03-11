package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utils.WaitUtils;

public class MultiOptionPage {
	private WebDriver driver;
	
	public MultiOptionPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private final By radioSet = By.id("radio-btn-example");
	private final By radio1 = By.cssSelector(".radioButton");

	public  void checkPresenceOfRadioButton() {
		WaitUtils.presentElement(driver , radioSet);
		
	}

	public void RadioButtonSelecton() {
		driver.findElement(radio1).click();
		Assert.assertTrue(driver.findElement(radio1).isSelected());
	}

		
	
}
