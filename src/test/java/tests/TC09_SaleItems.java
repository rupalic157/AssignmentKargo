package tests;

import org.testng.annotations.Test ;
import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ItemPage;
import pages.ShopPage;

public class TC09_SaleItems extends TestBasic{
	@Test(description = "Test Case 9: Sale Functionality ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on Sale written product in home page
			5) User can clearly view the actual price with old price striken for the sale written products""")
	public void verifySaleItems()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.selectSaleItem();						// Click on sale items
		
		ItemPage itemPage = new ItemPage(driver);
		itemPage.verifyDiscountedPrice();			// Verify The Items with their both prices
		
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
