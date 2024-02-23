package tests;


import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ShopPage;



public class TC03_SortWithPopularity extends TestBasic{
	@Test(description = "Test Case 3: Sorting Functionality - Popularity ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on Sort by Popularity item in Default sorting dropdown
			5) Now user can view the popular products only""")
	public void sortBy()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.sortByOption(POPULARITY); 				// Sort Products as per Popularity 
		
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
