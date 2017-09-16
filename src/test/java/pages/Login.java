package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Factory.DataProviderFactory;
import Utility.HelperClass;

public class Login 
{
	
	WebDriver driver;
	
	public Login(WebDriver ldriver)
	{
	 driver =  ldriver;
	}

	@FindBy(id="log") WebElement username;
	
	//alternate way is :
	//@FindBy(how=How.id, using="log") WebElement username1 ;
	
	
	@FindBy(name="pwd") WebElement password;
	@FindBy(xpath=".//*[@id='login']") WebElement loginButton;
	
	public void logintoApplication()
	
	{
		username.sendKeys(DataProviderFactory.getExcelConfig().getStringData("Login", 0, 0));
		System.out.println("Username Entered");
		
		password.sendKeys(DataProviderFactory.getExcelConfig().getStringData("Login",0 , 1));
		System.out.println("Pass Entered");
		
		loginButton.click();
		System.out.println(" Click on Login Button");
		
		
	}
	
	public void logintoApplication(String username1 , String password1)
	
	{
		
		HelperClass.highLightElement(driver, username).sendKeys(username1);
		//username.sendKeys(username1);
		System.out.println("Username Entered");
		
		HelperClass.highLightElement(driver, password).sendKeys(password1);
		//password.sendKeys(password1);
		System.out.println("Pass Entered");
		
		HelperClass.highLightElement(driver, loginButton).click();
		//System.out.println(" Click on Login Button");
		
		Assert.assertTrue(false);
	}
	
	
	
}
