package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Factory.DataProviderFactory;
import Utility.BaseClass;
import pages.HomePage;
import pages.Login;
// In case excel file contains header

public class DDTwithExcel1  extends BaseClass{
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
		
		Object[][]arr = new Object[rowcount-1][2];
		
		
		for (int i=1 ; i < rowcount ; i ++)
	
		{
			int columncount = DataProviderFactory.getExcelConfig().getNumberofColumns("ToolsqaLogin", i);
			
			for (int j = 0; j < columncount ; j++) 
			{
				arr[i-1][j]=DataProviderFactory.getExcelConfig().getData("ToolsqaLogin", i , j);
			}
		}
		 System.out.println("Data provider ready to use");
		 
		 
		 return arr;
		 
		 
	}

}
