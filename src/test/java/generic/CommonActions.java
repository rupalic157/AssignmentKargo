package generic;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CommonActions {
	public static WebDriver driver;
	
//Wait till specific element is displayed on page	
	public static void visibilityOfElement(WebDriver driver, long time, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

//Soft Assert
	public static void softAssert()
	{
		SoftAssert soft = new SoftAssert();
		soft.assertAll();
	}

//List of Elements List and select value EQUALS to the element list
	public static void selectListComponent(List<WebElement> options, String textToBeCompare)
	{
		for(WebElement list : options)
		{
			if(list.getText().equals(textToBeCompare))
			{
				list.click();
				break;
			}
		}
	}

//List of elements from Radio Button and select value CONTAINS within the element list
	public static void selectOptionRadioButton(List<WebElement> options, String selectOption)
	{
		for(WebElement list : options)
		{
			if(list.getAttribute("value").contains(selectOption))
			{
				list.click();
				break;
			}
		}
	}

//select from drop down list
	public static void selectValueFromDropdown(WebElement options, String value)
	{
		Select dropDown = new Select(options);
		waitTime(1000);
		dropDown.selectByVisibleText(value);
		
	}
	
//wait time
	public static void waitTime(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void pageVerify(WebDriver driver, String titleVerify)
	{
		waitTime(2000);
		String givenTitle = driver.getTitle();
		String expectedTitle = titleVerify;
		Assert.assertEquals(givenTitle,  expectedTitle, "Page title does not match ..");
	}
		
}
