package com.ShopOn.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	private String fileLocation ;
	private String sheetName;
	private Sheet excelSheet;
	public ReadExcel() {
		super();
	}
	public ReadExcel(String fileLocation, String sheetName) throws IOException {
		super();
		this.fileLocation = fileLocation;
		this.sheetName = sheetName;
	}
	
	public void ReadSheet(Sheet Sheet) {
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		System.out.println(rowCount);
		//Create a loop over all the rows of excel file to read it
		for (int i = 1; i < rowCount+1; i++) {
			Row row = Sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"\t\t");
			}
			System.out.println();
		} 
	}
	
	public Sheet setExcelSheet() throws IOException {
		File file = new File(fileLocation);
		//File file = new File("C:\\Users\\randy\\Downloads\\Git Projects\\Excel Read\\example1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook example1 = null;
		example1 = new XSSFWorkbook(inputStream);
		Sheet exampleSheet = example1.getSheet(sheetName);
		//Sheet exampleSheet = example1.getSheet("Sheet1");
		return exampleSheet;
	}
	
	public String readCellData(int vRow, int vColumn)  
	{  
	String value=null;          //variable for storing the cell value  
	Workbook wb=null;           //initialize Workbook null  
	try  
	{  
	//reading data from a file in the form of bytes  
	FileInputStream fis=new FileInputStream(fileLocation);  
	//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
	wb=new XSSFWorkbook(fis);  
	}  
	catch(FileNotFoundException e)  
	{  
	e.printStackTrace();  
	}  
	catch(IOException e1)  
	{  
	e1.printStackTrace();  
	}  
	Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
	Row row=sheet.getRow(vRow); //returns the logical row  
	Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
	value=cell.getStringCellValue();    //getting cell value  
	return value;               //returns the cell value  
	}  
	
public int getRowCount() {
		
		Workbook wb=null;           //initialize Workbook null  
		try  
		{  
		//reading data from a file in the form of bytes  
		FileInputStream fis=new FileInputStream(fileLocation);  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		wb=new XSSFWorkbook(fis);  
		}  
		catch(FileNotFoundException e)  
		{  
		e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
		e1.printStackTrace();  
		}  
		Sheet sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rowCount;
		
	}
	
	
	public int lastCell() {
		Workbook wb=null;           //initialize Workbook null  
		try  
		{  
		//reading data from a file in the form of bytes  
		FileInputStream fis=new FileInputStream("D:\\2019\\LoginDetails.xlsx");  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		wb=new XSSFWorkbook(fis);  
		}  
		catch(FileNotFoundException e)  
		{  
		e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
		e1.printStackTrace();  
		}  
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(0);
		int lastcell=row.getLastCellNum();
		return lastcell;
		
	}
	

}
