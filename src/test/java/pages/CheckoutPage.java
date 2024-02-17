package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.CommonActions;


public class CheckoutPage {
	
	//XPATHs for the required elements on the page
	@FindBy(id = "billing_first_name")
	private WebElement firstName;
	
	@FindBy(id = "billing_last_name")
	private WebElement lastName;
	
	@FindBy(id = "billing_company")
	private WebElement companyName;
	
	@FindBy(id = "billing_email")
	private WebElement emailId;
	
	@FindBy(id = "billing_phone")
	private WebElement phoneNumber;
	
	@FindBy(id = "billing_address_1")
	private WebElement addressField1;

	@FindBy(id = "billing_address_2")
	private WebElement addressField2;

	@FindBy(id = "billing_city")
	private WebElement townCity;
	
	@FindBy(id = "billing_postcode")
	private WebElement postCode;
	
	@FindBy(xpath = "//div[@id='payment']//ul//li//input")
	private List<WebElement> selectPaymentOptions;
	
	@FindBy(xpath = "//div[@id='s2id_billing_country']")
	private WebElement selectCountry;
	
	@FindBy(xpath = "//ul[@role='listbox']/li/descendant::div[@class='select2-result-label']")
	private List<WebElement> listCountries;
	
	@FindBy(id = "s2id_autogen1_search")
	private WebElement typeCountry;
	
	@FindBy(id = "place_order")
	private WebElement placeOrder;
	
	@FindBy(id = "s2id_billing_state")
	private WebElement selectState;
	
	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	private WebElement typeState;
		
	@FindBy(xpath = "//ul[@class='select2-results']//li/descendant::div[@class='select2-result-label']")
	private List<WebElement> listStates;
	
	@FindBy(xpath = "//input[@name='payment_method']")
	private List<WebElement> paymentOptions;
	
	@FindBy(id = "order_comments")
	private WebElement orderNotes;
	
	@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[2]")
	private WebElement subTotal;
	
	@FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[3]")
	private WebElement taxAmount;
	
	@FindBy(xpath = "//tr[@class='order-total']//span[@class='woocommerce-Price-amount amount']")
	private WebElement totalValue;
	

    private WebDriver driver;
    
    // Opening the Checkout Page
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    // Filling values in all the fields
	public void firstName(String fName) {
		CommonActions.waitTime(2000);
		firstName.sendKeys(fName);
	}

	public void lastName(String lname) {
		CommonActions.waitTime(2000);
		lastName.sendKeys(lname);
	}

	public void companyName(String cpyName) {
		CommonActions.waitTime(2000);
		companyName.sendKeys(cpyName);
	}

	public void emailId(String eId) {
		CommonActions.waitTime(2000);
		emailId.sendKeys(eId);
	}

	public void phoneNumber(String pNumber) {
		CommonActions.waitTime(2000);
		phoneNumber.sendKeys(pNumber);
	}

	public void addressField1(String aField1) {
		CommonActions.waitTime(2000);
		addressField1.sendKeys(aField1);
	}

	public void addressField2(String aField2) {
		CommonActions.waitTime(2000);
		addressField2.sendKeys(aField2);
	}
	public void cityName(String ctName) {
		CommonActions.waitTime(2000);
		townCity.sendKeys(ctName);
	}

	public void postCode(String pCode) {
		CommonActions.waitTime(2000);
		postCode.sendKeys(pCode);
	}

	public void orderNote(String oNote) {
		CommonActions.waitTime(2000);
		orderNotes.sendKeys(oNote);
	}
	
	public void selectCountry(String countryName) {
		CommonActions.waitTime(2000);
		selectCountry.click();
		typeCountry.sendKeys(countryName);
		CommonActions.waitTime(2000);		
		CommonActions.selectListComponent(listCountries, countryName);
	}
	
	public void stateName(String stateName) {
		CommonActions.waitTime(2000);
		selectState.click();
		typeState.sendKeys(stateName);
		CommonActions.waitTime(2000);		
		CommonActions.selectListComponent(listStates, stateName);
	}
	
	public void selectPayment(String value) {
		CommonActions.waitTime(2000);
		CommonActions.selectOptionRadioButton(paymentOptions, value);
	}
	
    public void clickPlaceOrder() {
		 CommonActions.waitTime(2000);	
		 placeOrder.click();
	}
    
    
    // Verify the Tax Amount as per country
	public void verifyTaxWithCountry(String country) {
		
		float sTotal = Float.parseFloat(subTotal.getText().substring(1));
		CommonActions.waitTime(2000);
		selectCountry.click();
		CommonActions.waitTime(2000);	
		CommonActions.selectListComponent(listCountries, country);
		CommonActions.waitTime(2000);	
		
		float taxAmt = Float.parseFloat(taxAmount.getText().substring(1));
		if(country == "India") {
			float tempVal = sTotal * 2 / 100 ;
			Assert.assertEquals(taxAmt, tempVal, "WRONG TAX CALCULATION FOR INDIA");
		}
		else {
			float tempVal = sTotal * 5 / 100 ;
			Assert.assertEquals(taxAmt, tempVal, "WRONG TAX CALCULATION FOR OTHER COUNTRY");
		}
	}


}