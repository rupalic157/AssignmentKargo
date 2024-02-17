package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.CommonActions;

public class CartPage {

	//XPATHs for the required elements on the page
	@FindBy(xpath = "//td[@data-title='Tax']")
	private WebElement taxAmount;
	
	@FindBy(xpath = "//td[@data-title='Subtotal']")
	private WebElement subTotal;
	
	@FindBy(xpath = "//tr[@class='order-total']//td")
	private WebElement totalValue;
	
	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckout;
	
    private WebDriver driver;
    
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    //Click on Proceed to CHeckout Button
    public void proceedToCheckout() {	
    	
		 CommonActions.waitTime(1000);	
		 proceedToCheckout.click();
	}

   
    // Verifying the Sub-total value with the total value
    public void verifyTotalWithSubtotalValue() {
   	 	CommonActions.waitTime(3000);	   	 
      	float sTotal = Float.parseFloat(subTotal.getText().substring(1));
       	float tValue = Float.parseFloat(totalValue.getText().substring(1));
   
       	Assert.assertTrue(tValue > sTotal,  "Sub Total is Incorrect");   	 

	}
    
    
}