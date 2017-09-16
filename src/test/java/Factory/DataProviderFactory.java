package Factory;

import DataProvider.ConfigReader;
import DataProvider.ExcelConfig;

public class DataProviderFactory {
	

		
		public static ConfigReader getConfig()
		{
			ConfigReader reader = new ConfigReader();
					return  reader;
		}
		
		public static ExcelConfig getExcelConfig()
		{
			ExcelConfig reader = new ExcelConfig();
					return  reader;
		}
	}

