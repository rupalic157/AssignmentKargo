package tests;


import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ShopPage;



public class TC07_SortWithHighToLow extends TestBasic{
	@Test(description = "Test Case 7: Sorting Functionality - High to Low ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on Sort by High to Low Item in Default sorting dropdown
			5) Now user can view the popular products only""")
	public void sortBy()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.verfiySort(HTL);						// Sort & Verify Products as per High to Low 
			
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
