package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperClass {

	
	public static String takesScreeshot(WebDriver ldriver , String name)
	{
		TakesScreenshot ts =  (TakesScreenshot)ldriver ;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/Screenshots/"+name+".png" ;
		
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			System.out.println("Cannot Capture ScreenShot");}
		
		return path ;
		}
		
		public static String takesScreeshotwithTimeStamp(WebDriver ldriver )
		{
			TakesScreenshot ts =  (TakesScreenshot)ldriver ;
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png" ;
			
			File destination = new File(path);
			
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				
				System.out.println("Cannot Capture ScreenShot");
			}
		
			 return path ;
		
		}
		
		
		public static WebElement highLightElement(WebDriver driver , WebElement element)
		
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			 js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
			 
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				System.out.println(e.getMessage());
			}
			
 js.executeScript("arguments[0].setAttribute('style','border: 2px solid white');",element);
			 
			
			return element;
			
			
					
		}
}
