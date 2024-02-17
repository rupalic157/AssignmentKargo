package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.CommonActions;

public class ItemPage {
	
	//XPATHs for the required elements on the page
	@FindBy(xpath = "//button[text()='Add to basket']")
	private WebElement addToBasket;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']")
	private WebElement addIntoBasketMessage;
	
	@FindBy(xpath = "//span[@class = 'posted_in']//a")
	private WebElement itemCatagory;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']/a")
	private WebElement viewBasket;
	
	@FindBy(xpath = "//a[@class='wpmenucart-contents']")
	private WebElement itemsList;
	
	@FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']/parent::ins")
	private WebElement discountedPrice;

	@FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']/parent::del")
	private WebElement oldPrice;

	
    private WebDriver driver;

 // Opening the Specific Item Page
    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    //clicks within the page
    public void addToCartOnItemPage() {
   	 	CommonActions.waitTime(3000);	 
   	 	addToBasket.click();
	}
    public void viewBasketOnItemPage() {
		 CommonActions.waitTime(3000);	
		 viewBasket.click();
	}
    
    public void listOfItems() {
		 CommonActions.waitTime(3000);	
		 itemsList.click();
	}    
    
    //Verify the Discounted price with the original Price (Striked)
    public void verifyDiscountedPrice() {
   	 	CommonActions.waitTime(3000);	   	 
      	float dPrice = Float.parseFloat(discountedPrice.getText().substring(1));
       	float oPrice = Float.parseFloat(oldPrice.getText().substring(1));
   	    Assert.assertTrue(oPrice > dPrice,  "Price is Not Discounted");   	 
    }
   
}