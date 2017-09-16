package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utility.BaseClass;
import pages.HomePage;
import pages.Login;


public class LoginToStore extends BaseClass {
	
	
	@Test
	public void testInvalidLogin()
	{
		
		BaseClass.logger = reports.createTest("testInvalidLogin");
	  HomePage home1 = PageFactory.initElements(driver, HomePage.class);
	  home1.verifyPageTitle();
	  
	
	  home1.clickonAccountLink();
	  
	  Login loginpage = PageFactory.initElements(driver, Login.class);
		
		loginpage.logintoApplication("Selenium", "Password");



	}

}
