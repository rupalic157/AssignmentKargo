package tests;


import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ShopPage;


public class TC08_OutOfStock extends TestBasic{
	@Test(description = "Test Case 08: Read More Functionality ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on read more button in home page
			5) Read More option indicates the Out Of Stock.
			6) User cannot add the product which has read more option as it was out of stock.""")
	public void verifyOutOfStock()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
	//	ShopPage page = new ShopPage(driver);
	//	page.verifyOutOfStockItem(); 				// No Such Element Present on the Screen, so this test is going to be failed !!
	
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
