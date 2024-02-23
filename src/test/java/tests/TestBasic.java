package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import generic.AutoConstants;
import generic.CommonActions;
import generic.LoadProperties;

public class TestBasic implements AutoConstants{
public WebDriver driver;

	@Parameters("browsername")
	@BeforeMethod(alwaysRun=true)
	public void preCondition(String browsername)
	{
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(GeckoExe, GeckoPath);
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Chrome"))
			{
			if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty(ChromedriverKey, ChromedriverPath);
			driver = new ChromeDriver();
		}
		}
		else
		{
			System.setProperty(IE_EXE, IE_PATH);
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String str = LoadProperties.getPropertyValue("url");
		driver.get(str);
		//String givenTitle = driver.getTitle();
		//String expectedTitle = "Automation Practice Site";
		//Assert.assertEquals(givenTitle,  expectedTitle, "Home Page title does not match ..");
		CommonActions.pageVerify(driver, HOMEPAGE);
	}
	
	@AfterMethod(alwaysRun=true)
	public void postCondition()
	{
		driver.close();
		driver.quit();
	}
/*	
	@AfterTest
	public void endReport() 
	{
		extent.flush();
	}
*/
}
