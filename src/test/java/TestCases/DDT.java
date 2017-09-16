package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.BaseClass;
import pages.HomePage;
import pages.Login;

public class DDT  extends BaseClass{
	@Test(dataProvider = "TestData")
	public void createAccount( String testusername , String testpassword)
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		home.clickonAccountLink();
		
		Login loginpage = PageFactory.initElements(driver, Login.class);
		
		loginpage.logintoApplication(testusername, testpassword);
	}
	
	@DataProvider(name="TestData")
	public Object[][] applicationData()
	{
		Object[][]arr = new Object[2][2];
		 arr[0][0]  = "Selenium";
		 arr[0][1]  = "IDE";
		 arr[1][0]  = "QTP";
		 arr[1][1]  = "HP";
		 
		 return arr;
		 
		 
	}

}
