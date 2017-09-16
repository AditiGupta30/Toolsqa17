package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Factory.DataProviderFactory;
import Utility.BaseClass;
import pages.HomePage;
import pages.Login;

public class DDTwithExcel  extends BaseClass{
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
		
		System.out.println("Data is getting loaded");
		
		int rowcount = DataProviderFactory.getExcelConfig().getNumberofRows("ToolsqaLogin");
		
		System.out.println("test will execute " + rowcount +" Times");
		
		Object[][]arr = new Object[rowcount][2];
		// We get index out of bound exception if we do i<=rowcount , use i<rowcount
		
		for(int i= 0 ; i< rowcount ; i++)
			
		{
			arr[i][0]=DataProviderFactory.getExcelConfig().getData("ToolsqaLogin", i , 0);
			arr[i][1]=DataProviderFactory.getExcelConfig().getData("ToolsqaLogin", i , 1);
		}
		
		 System.out.println("Data provider ready to use");
		 
		 
		 return arr;
		 
		 
	}

}
