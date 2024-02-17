package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.CommonActions;

public class ShopPage {
	
	//XPATHs for the required elements on the page	
	@FindBy(xpath = "//a[text()='Shop']")
	private WebElement shop;
	
	@FindBy(xpath = "//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]")
	private WebElement lSlider;
	
	@FindBy(xpath = "//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]")
	private WebElement rSlider;
	
	@FindBy(xpath = "//div[@class='price_label']/span[1]")
	private WebElement minSetPrice;

	@FindBy(xpath = "//div[@class='price_label']/span[2]")
	private WebElement maxSetPrice;
	
	@FindBy(xpath = "//button[text()='Filter']")
	private WebElement filterButton;
		
	@FindBy(xpath = "//ul[@class='product-categories']//li/a")
    private List<WebElement> productCategories;
   
	@FindBy(name = "orderby")
    private WebElement sortOptions;
	
	@FindBy(xpath = "//a[text()='View Basket']")
    private WebElement viewBasket;

	@FindBy(xpath = "//a[@class='wpmenucart-contents']")
	private WebElement itemsList;
	
	@FindBy(xpath = "//a[text()='Read More']")
    private WebElement readMore;

	@FindBy(xpath = "//span[@class='onsale']")
	private WebElement saleProduct;
	
	@FindBy(xpath = "//a[text()='Add to basket']")
	private WebElement addToBasket;
	
	@FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    private List<WebElement> allProductPriceIncDiscounted;
    
	@FindBy(xpath = "//span[@class='price']//del")
    private List<WebElement> allDiscountedPrices;
    
	@FindBy(xpath = "//*[@class='woocommerce-LoopProduct-link']//h3")
	private List<WebElement> productList;
	
    private WebDriver driver;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
  
    //Clicks on the page
	public void addToBasket() {
		CommonActions.waitTime(1000);
		addToBasket.click();
	}

	public void viewBasket() {
		CommonActions.waitTime(1000);
		viewBasket.click();
	}
	
	public void itemsList() {
		CommonActions.waitTime(1000);
		itemsList.click();
	}
	
	public void selectSaleItem() {	
		CommonActions.waitTime(1000);
		saleProduct.click();
	}

	//verify out of stock items
	public void verifyOutOfStockItem() {
		CommonActions.waitTime(2000);
		viewBasket(); // read more we assume
	
	}
    
	//Passing Filter Values as per min and max
	public void filterRange(int min , int max) {
		
		Actions action = new Actions(driver);	
		int minPrice = Integer.valueOf(minSetPrice.getText().substring(1));
		int maxPrice = Integer.valueOf(maxSetPrice.getText().substring(1));
	  
		for( int i = minPrice; i < min; i++) {
			rSlider.click();
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();	
		}
		
		for(int i = maxPrice; i > max; i--) {
			rSlider.click();
			action.sendKeys(Keys.ARROW_LEFT).build().perform();		
		}

		CommonActions.waitTime(2000);
		filterButton.click();
	
	}
	
	// filter items by category
	public void selectCategory(String category) {
		CommonActions.waitTime(2000);		
		CommonActions.selectListComponent(productCategories, category);		
	}
	
	// Sort items as per requirement
	public void sortByOption(String selectedOption) {	
		CommonActions.waitTime(2000);		
		CommonActions.selectValueFromDropdown(sortOptions, selectedOption);		
	}
	
	// Select Product from the all available products 
	public void selectProduct(String item) {
		 CommonActions.waitTime(2000);	 
		 CommonActions.selectListComponent(productList, item);	
	}
	
	
	//low to high & high to low
	
	public void verfiySort(String sortOption) {
		 CommonActions.waitTime(2000);	 
		 
		 // Take All Strike Values in a list and convert them into Float
		 List<WebElement> discountedPrices = allDiscountedPrices;
		 List<Float> discountedPricesList = new ArrayList<>();
		 
		 for(WebElement b: discountedPrices) {
			 discountedPricesList.add(Float.valueOf(b.getText().substring(1)));
		 }
		 
		// Take All item Values (before sort) Into a list and convert them into Float
		 List<WebElement> allItemsPriceBefore = allProductPriceIncDiscounted;	 
		 List<Float> beforeFilterPriceList = new ArrayList<>();

		 for(WebElement b: allItemsPriceBefore) {
			 beforeFilterPriceList.add(Float.valueOf(b.getText().substring(1)));
		 }
		 
		 beforeFilterPriceList.removeAll(discountedPricesList); //remove strike values from the list (before sort)

		 sortByOption(sortOption); 	//sort by using XPATH
		 
		// Take All item Values (after sort) Into a list and convert them into Float
		 List<WebElement> allItemsPriceAfter = allProductPriceIncDiscounted;
		 List<Float> afterFilterPriceList = new ArrayList<>();
		 
		 for(WebElement a: allItemsPriceAfter) {
			 afterFilterPriceList.add(Float.valueOf(a.getText().substring(1)));
		 }

		 afterFilterPriceList.removeAll(discountedPricesList);  //remove strike values from the list (after sort)
		 
		 if(sortOption == "Sort by price: low to high") {
			 Collections.sort(beforeFilterPriceList); //ascending sort
		 }
		 else {
			 Collections.sort(beforeFilterPriceList);
			 Collections.reverse(beforeFilterPriceList);  //descending sort
		 }

		 CommonActions.waitTime(2000);	 
		 Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList, "Items are not sorted ");
	
	}
	
	
	
	
	
	
	
}