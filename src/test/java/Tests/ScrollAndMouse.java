package Tests;

import org.testng.annotations.Test;

import PageObjects.ScrollPage;

public class ScrollAndMouse extends BaseRahul{

	@Test
	public void ScrollToElement() {
		ScrollPage spage = new ScrollPage(driver);
		spage.ScrollDown();
	}
	@Test
	public void alertCheck() {
		ScrollPage spage = new ScrollPage(driver);
		spage.alertChecking();
	}
}

