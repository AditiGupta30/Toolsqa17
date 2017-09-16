package DataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	
	public ConfigReader()  {
		
		File src = new File("./Configuration File/config.properties");
		try {
			FileInputStream Fis = new FileInputStream(src);
			
			pro = new Properties();

				pro.load(Fis);
				
				System.out.println("Config file loaded properly");
			
		} catch (Exception e) {
			System.out.println("Config file not loaded properly" +e.getMessage());
		}
		
	}
	
	public String getFireFoxPath() {
		
		return pro.getProperty("FirefoxPath");
	}

public String getChromePath() {
		
		return pro.getProperty("ChromePath");
	}
public String getIEPath() {
	
	return pro.getProperty("IEPath");
}

public String gettestUrl() {
	
	return pro.getProperty("testurl");
}

}
