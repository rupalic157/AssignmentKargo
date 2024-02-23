package tests;

import org.testng.annotations.Test ;
import generic.CommonActions;
import io.qameta.allure.Description;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderConfirmationPage;
import pages.ShopPage;

public class TC11_ItemListOnMenu extends TestBasic{
	@Test(description = "Test Case 11: View Basket by Item On Top Right ")
	@Description("""
			1) Open the browser
			2) Enter the URL “http://practice.automationtesting.in/”
			3) Click on Shop Menu
			4) Click on the Add To Basket button which adds that book to your basket
			5) User can view that Book in the Menu item with price .
			6) Now click on Item link which navigates to proceed to check out page.
			7) Now user can find total and subtotal values just above the Proceed to Checkout button.
			8) The total always < subtotal because taxes are added in the subtotal
			9) Now click on Proceed to Check out button which navigates to payment gateway page.
			10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
			11) Now user can fill his details in billing details form and can opt any payment in the payment gateway
			    like Direct bank transfer,cheque,cash or paypal.
			12) Now click on Place Order button to complete process
			13) On clicking place order button user completes his process where the page navigates to Order confirmation 
			    page with order details,bank details,customer details and billing details""")
	public void verifyAddBasketWithItemLink()
	{
		HomePage homePage = new HomePage(driver);
		homePage.giveConsent();
		homePage.shopPage();						// Click on shop Menu
		CommonActions.pageVerify(driver, SHOPPAGE);	// Verifying the shop page
		
		ShopPage page = new ShopPage(driver);
		page.addToBasket();							// Click on Add To Basket Button
		page.itemsList();							// Click on Item Section On Top Right of the Page
		CommonActions.pageVerify(driver, CARTPAGE);	// Verifying the cart page
		
		CartPage cartPage = new CartPage(driver);		
		cartPage.verifyTotalWithSubtotalValue();	// Verifying the sub total and total amount
		cartPage.proceedToCheckout();				// Click On Proceed To Checkout
		CommonActions.pageVerify(driver, CHECKOUT);	// Verifying the checkout page
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		// Passing All the Values For Billing Details
		checkoutPage.firstName(FIRSTNAME); 
		checkoutPage.lastName(LASTNAME);
		checkoutPage.companyName(COMPANYNAME);
		checkoutPage.emailId(EMAILID);
		checkoutPage.phoneNumber(PHONE);
		checkoutPage.selectCountry(COUNTRY);
		checkoutPage.addressField1(ADDRESSFIELD1);
		checkoutPage.addressField2(ADDRESSFIELD2);
		checkoutPage.cityName(CITY);
		checkoutPage.stateName(STATE);
		checkoutPage.postCode(POSTCODE);
		checkoutPage.orderNote(ORDERNOTE);
		checkoutPage.selectPayment(PAYMENTOPTION);
		checkoutPage.clickPlaceOrder();				// Click on Place Order
		
		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		ocp.verifyOrderNumber();					// Verifying the Order Number
		ocp.verifyMessage();						// Verifying the Greeting Message
		
		CommonActions.waitTime(2000);
		CommonActions.softAssert();
	}

}
