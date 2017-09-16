package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver startbrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("Firefox"))
			{	
		
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFireFoxPath());
			driver = new FirefoxDriver();
			
		}
		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
			
		}
		
		if(browsername.equalsIgnoreCase("IE"))
		{	
			
			
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver = new InternetExplorerDriver();
			
		}
		
		
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
}}


