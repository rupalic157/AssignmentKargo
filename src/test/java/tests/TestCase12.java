package tests;


import org.testng.annotations.Test ;

import generic.CommonActions;
import io.qameta.allure.Description;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ShopPage;


public class TestCase12 extends TestBasic{
	@Test(description = "Test Case 12: Check tax value as per country requirements ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on the Add To Basket button which adds that book to your basket
			5) User can view that Book in the Menu item with price .
			6) Now click on Item link which navigates to proceed to check out page.
			7) Now user can find total and subtotal values just above the Proceed to Checkout button.
			8) The total always < subtotal because taxes are added in the subtotal
			9) The tax rate variers for India compared to other countries
			10) Tax rate for indian should be 2% and for abroad it should be 5%""")
	public void verifyTaxRate()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.addToBasket();							// Click on Add To Basket Button
		page.viewBasket();							// Click on View Basket Button
		CommonActions.pageVerify(driver, CARTPAGE);	// Verify the cart page
		
		CartPage cartPage = new CartPage(driver);		
		cartPage.verifyTotalWithSubtotalValue();	// Verify the sub total and total amount
		cartPage.proceedToCheckout();				// Click On Proceed To Checkout
		CommonActions.pageVerify(driver, CHECKOUT);	// Verify the checkout page
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.verifyTaxWithCountry(COUNTRY);		// Verify the 2% tax amount for a Country
		checkoutPage.verifyTaxWithCountry(OTHERCOUNTRY);// Verify the 5% tax amount for Other Country
	
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
