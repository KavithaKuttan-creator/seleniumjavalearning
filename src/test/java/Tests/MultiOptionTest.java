package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.MultiOptionPage;
import io.qameta.allure.Description;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class MultiOptionTest extends BaseRahul{
	
	@Test(description ="Radio Button presence")
	@Description("Search a product From FlipkaRadio Button presence")
	public void radioButtonPresence() {
		MultiOptionPage radio = new MultiOptionPage(driver);
		radio.checkPresenceOfRadioButton();
	}
	
	@Test(description ="Radio Button selection")
	@Description("Radio Button selection")
	public void radioButtonSelection() {
		MultiOptionPage radio = new MultiOptionPage(driver);
		radio.RadioButtonSelecton();
	}

}
