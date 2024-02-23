package tests;


import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ShopPage;



public class TC02_FilterWithCategory extends TestBasic{
	@Test(description = "Test Case 2: Product Category")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click any of the product links available in the product category
			5) Now user can view only that particular product""")
	public void filterByCategory()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						 // Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	 // Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.selectCategory("HTML");  				// Click on the product category and display the specific items 

		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
