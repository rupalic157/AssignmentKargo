package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.CommonActions;

public class HomePage {
	
	//XPATHs for the required elements on the page
	@FindBy(xpath = "//p[text()='Do not consent']")
	private WebElement giveConsent;
	
	@FindBy(xpath = "//a[text()='Shop']")
	private WebElement shopPage;
	
    private WebDriver driver;

    // Opening the Home Page
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    // Click on give consent
    public void giveConsent() {	
   	 	CommonActions.waitTime(3000);	 
   	 	giveConsent.click();		
	}
    
    // Click on Shop Page from Menu
    public void shopPage() {	
		 CommonActions.waitTime(2000);	
		 shopPage.click();
	}

   
}