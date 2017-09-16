package DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	//Global Variable declaration 
	XSSFWorkbook wb;
	
	//this is a constructor
	public ExcelConfig()
	
	{
        File src = new File("./TestData/appdata.xlsx");
		
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			  wb =  new XSSFWorkbook(fis);
			  
			  System.out.println("File is succesfully loaded");
			
		} catch (Exception e) {
			
			System.out.println("Unable to load file");
			
			e.printStackTrace();
		}
		
		      
	}

	public String getStringData(String sheetName, int rowIndex , int columnIndex)
	{
		String Data = wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		
		return Data;
		
	}
	
	
	public XSSFSheet getSheetObject(String sheetname)

	{
		return wb.getSheet(sheetname);	}
	
	
	public int getNumberofRows(String sheetname)
	{
		int rowcount = wb.getSheet(sheetname).getPhysicalNumberOfRows();
		return rowcount;
		
	}
	
	public int getNumberofColumns(String sheetname, int row)
	{
		int rowcount = wb.getSheet(sheetname).getRow(row).getPhysicalNumberOfCells();
		
		return rowcount;
		
	}
	
	public int getNumericData(String sheetName, int rowIndex , int columnIndex)
	{
		int Data = (int)wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
		
		return Data;
		
	}
	
	public void setExcelData(String sheetName, int rowIndex , int columnIndex , String result)
	
	{
		wb.getSheet(sheetName).getRow(rowIndex).createCell(columnIndex).setCellValue(result);

	}
	
	public Object getData(String sheetName, int rowIndex , int columnIndex)
	
	{
		CellType type = wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getCellTypeEnum();
	
	
	switch(type)
	{
	 
	case STRING:
		return getStringData(sheetName, rowIndex, columnIndex);
		
		
	case NUMERIC:
		return getNumericData(sheetName, rowIndex, columnIndex);

		default:
			break;
		
		
		
	}
	return type;
	
		
	}
}
