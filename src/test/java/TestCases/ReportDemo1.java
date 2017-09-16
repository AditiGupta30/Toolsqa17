package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportDemo1 {
	
	@Test
	public void test1()
	{
		ExtentHtmlReporter HTMLReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Report\\Toolsqa.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(HTMLReporter);
		 
		ExtentTest Test = extent.createTest("VerifyHomePage","This test will verify Homepage Details");
		 
		Test.log(Status.INFO, "Browser Started");
		Test.log(Status.INFO, "Application Started");
		Test.log(Status.PASS, "Verified error message");
		try {
			Test.pass("Pass").addScreenCaptureFromPath("C:\\Users\\30175102\\Selenium\\Screenshots\\SingleRadioButton.PNG");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
		
		
		
		extent.flush();
		
		
	}
	

}
