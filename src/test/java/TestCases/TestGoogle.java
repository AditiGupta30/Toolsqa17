package TestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;

public class TestGoogle extends BaseClass{
	
	@Test
	public void testcase1()
	{
		String Title = driver.getTitle();
		
		System.out.println("Print Title "+Title);
	}
	
	@Test
	public void testcase2()
	{
		String url = driver.getCurrentUrl();
		
		System.out.println("Print Title "+url);
	}

}
