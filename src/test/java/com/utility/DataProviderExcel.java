package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderExcel {
	
	/*
	 * @author Avinash Bhalerao
	 * This is a dyanamic data provider class which automatically detects the number of column and row in Excel sheet
	 * But we havecreate 
	 */
	
	
	public static String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException
	{
		File file =new File(System.getProperty("user.dir")+"\\config-framework\\test-data\\TestData.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(stream);
		Sheet sheetName = workbook.getSheet(excelSheetName);
		
		int totolRowsNumber = sheetName.getLastRowNum();
		System.out.println(totolRowsNumber);
		
		Row rowCells = sheetName.getRow(0);
		int totalColumn = rowCells.getLastCellNum();
		System.out.println(totalColumn);
		
		DataFormatter format = new DataFormatter();
		
		String testData [][]= new String[totolRowsNumber][totalColumn];
		
		for(int i=1; i<=totolRowsNumber; i++)
		{
			for(int j=0;j<totalColumn;j++)
			{
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	
	
	}
	
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		
//		DataProviderExcel h=new DataProviderExcel();
//		h.getData();
//		
//	}

}
