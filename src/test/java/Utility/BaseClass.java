package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class BaseClass {
	
	protected WebDriver driver ;
	protected ExtentHtmlReporter HTMLReporter;
	protected ExtentReports reports;
	protected static ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		HTMLReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Report\\"+"Toolsqa"+System.currentTimeMillis()+".html");
	 reports = new ExtentReports();
	 reports.attachReporter(HTMLReporter);
		
	}
	
	
	@AfterSuite
	public void tearDownReports()
	{
		reports.flush();
	}

	@AfterMethod
	public void Screenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = HelperClass.takesScreeshotwithTimeStamp(driver);
			try {
				BaseClass.logger.log(Status.INFO, "Captured ScreenShot").addScreenCaptureFromPath(path);
				BaseClass.logger.log(Status.FAIL, "TC Failed");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Parameters({"browser"})
	@BeforeClass
	public void startbrowser(String browser)
	{
		driver = BrowserFactory.startbrowser(browser);
		driver.get(DataProviderFactory.getConfig().gettestUrl());
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
		System.out.println("---Test complete--");
	}
}
