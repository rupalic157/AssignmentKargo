package tests;


import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ShopPage;


public class TestCase04 extends TestBasic{
	@Test(description = "Test Case 4: Sorting Functionality - Average ratings ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on Sort by Average ratings in Default sorting dropdown
			5) Now user can view the popular products only""")
	public void sortBy()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.sortByOption(AVERAGE);  				// Sort Products as per Average Ratings 
		
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
