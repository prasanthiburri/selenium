package com.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//C:\Users\SamJo\Desktop\java sw\excel data\TestData.xlsx
		File src = new File("C:\\Users\\SamJo\\Desktop\\java sw\\excel data\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet s1 = wb.getSheetAt(0);
        int rc =s1.getLastRowNum();
        System.out.println("Data in excel seet"+rc);
           
        try {
			for(int i=0;i<rc;i++)
			{
				
				String data0 = s1.getRow(i).getCell(0).getStringCellValue();
							System.out.println(data0);
				
				        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
		}
       
        s1.getRow(0).createCell(2).setCellValue("Pass");
        s1.getRow(1).createCell(2).setCellValue("Fail");
        FileOutputStream fos = new FileOutputStream(src);
        wb.write(fos);
        
         wb.close();
	}

}
