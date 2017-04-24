package library;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet s1;
	
	public  ExcelDataConfig(String excelpath )
	{
		try {
			File src=new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
			 
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
	}
	public String getData(int sheetnumber,int row,int column)
	{
		s1=wb.getSheetAt(sheetnumber);
		String data = s1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
}
