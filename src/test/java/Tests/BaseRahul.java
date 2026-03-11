package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ScreenshotUtil;

public class BaseRahul {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");		
	}
	
	@AfterMethod
	public void IfAnyFailureScreenshot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
	        ScreenshotUtil.takeScreenshot(driver);
	    }
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

}
