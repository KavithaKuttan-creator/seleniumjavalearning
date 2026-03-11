package Tests;

import org.testng.annotations.Test;

import PageObjects.WindowTabPage;

public class WindowTab extends BaseRahul {
	
	@Test(description = "Check for window")
	public void OpenWindow() {
		WindowTabPage window = new WindowTabPage(driver);
		window.openwindowLink();
	}
	
	 @Test(description = "Check for tab") 
	 public void OpenTabLink() {
	 WindowTabPage tab = new WindowTabPage(driver); 
	 tab.openTabLink();
	 } 
	 

}
