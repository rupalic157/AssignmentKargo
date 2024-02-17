package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage {
	
	//XPATHs for the required elements on the page
	@FindBy(xpath = "//li[@class='order']/strong")
	private WebElement orderNumber;
	
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement orderMessage;
	
    private WebDriver driver;
    
    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    //Verify the Order Number to make sure order is placed
    public void verifyOrderNumber() {
		String orderNo = orderNumber.getText();
		if( orderNo != null && !orderNo.equals("") ) {
			Assert.assertTrue(true , "PASS .... Order Placed Successfully !");
		}
		else {
			Assert.assertTrue(false , "FAIL .... Order Number Not Generated !");
		}	
    }   
    
    public void verifyMessage() {
		String message = orderMessage.getText();
		String expectedMsg = "Thank you. Your order has been received." ;
		Assert.assertEquals(message,  expectedMsg, "Order Message is not correct ..");
    }
    
}