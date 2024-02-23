package tests;

import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.ShopPage;


public class TC01_SetFilters extends TestBasic{
    
	@Test(description = "Test Case 1: Set Filter Limits")
	@Description("""
            1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Adjust the filter by price between 150 to 450 rps
			5) Now click on Filter button
			6) User can view books only between 150 to 450 rps price""")
	public void filterByPrice()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();	
		homePage.shopPage();						// Click on shop Menu
		
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		ShopPage page = new ShopPage(driver);	
		page.filterRange(MIN,MAX); 					// Adjust filter as per requirement & Display the updated list
		
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
		
	}

}
