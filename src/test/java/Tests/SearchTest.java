package Tests;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SearchProduct;
import io.qameta.allure.Description;

public class SearchTest extends BaseTest{

	String ExcelFileName ="src/test/resources/testdata.xlsx";
	@Test
	public void loginflipkart() {
		HomePage homePage = new HomePage(driver);
		homePage.homeLoadCheck();
	}
	
	@Test(description ="Open flipkart")
	@Description("Search a product From Flipkart")
	public void searchresult()  {
		HomePage homePage = new HomePage(driver);
		homePage.homeLoadCheck();
		
		try {
			homePage.searchField(ExcelFileName,"SearchProduct",0,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Test(description ="Check for the correct search result")
	@Description("Listing the matching products")
	public void searchResultPage() {
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.pageCorrectness();
	}

}
