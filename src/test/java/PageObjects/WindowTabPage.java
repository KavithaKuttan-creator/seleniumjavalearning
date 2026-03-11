package PageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.WaitUtils;

public class WindowTabPage {

	private WebDriver driver;
	public WindowTabPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private final By newWindowTxt = By.xpath("//*[text()='Switch Window Example']");
	private final By newTab = By.xpath("//*[@id='opentab']");
	private final By newWindow = By.xpath("//*[@id='openwindow']");
	
	public void openwindowLink() {
		WaitUtils.WaitForVisible(driver, newWindowTxt);
		//driver.findElement(newWindow).click();
		WebElement e = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable((newWindow)));
		e.click();
		String parentWindow = driver.getWindowHandle();
		Set <String> allWindowHandles = driver.getWindowHandles();
		for(String window : allWindowHandles) {
			if(!parentWindow.equals(window)){
				driver.switchTo().window(window);
				break;
			}
		}
		
		String newTitle = driver.getCurrentUrl();
		Assert.assertEquals(newTitle, "https://www.qaclickacademy.com/");
		driver.close();
		driver.switchTo().window(parentWindow);
		}
	
	public void openTabLink() {
		
		WaitUtils.WaitForClickable(driver ,newTab);
		driver.findElement(newTab).click();
		String parentWindow = driver.getWindowHandle();
		Set <String> allTab = driver.getWindowHandles();
		for(String tab : allTab) {
			if(!parentWindow.equals(tab)){
				driver.switchTo().window(tab);
				break;
			}
		}
		
		String newTitle = driver.getCurrentUrl();
		Assert.assertEquals(newTitle, "https://www.qaclickacademy.com/");
		driver.close();
		driver.switchTo().window(parentWindow);
		}
}
