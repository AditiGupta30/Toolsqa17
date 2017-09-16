package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Utility.BaseClass;
import Utility.HelperClass;

public class HomePage extends BaseClass

{
	
WebDriver driver ;

	
	public HomePage(WebDriver ldriver)
	
	{
		
		driver=ldriver;
		
	}
	
	
	@FindBy(xpath = "//*[@id='account']/a")
	
	WebElement accountLink;

	public void clickonAccountLink()
	{
		

		boolean status = accountLink.isDisplayed();
		boolean Enablestatus = accountLink.isEnabled();
		Assert.assertTrue(status);
		Assert.assertTrue(Enablestatus);
		if(status && Enablestatus)
		{
			
			HelperClass.highLightElement(driver, accountLink).click();
	
		BaseClass.logger.log(Status.PASS, "Account link Verified");
		}
	}

	public void verifyPageTitle()
	{
		Assert.assertTrue(driver.getTitle().contains("ONLINE STORE"));
		BaseClass.logger.log(Status.PASS, "Title Verified");
	}
	
	
	
}
