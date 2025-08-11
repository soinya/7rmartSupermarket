package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String getStringData(int a,int b,String sheet) throws IOException 
	{
		String filePath= Constants.TESTDATAPATH;
		f=new FileInputStream(filePath);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static String getIntegerData(int a,int b,String sheet) throws IOException 
	{
		String filePath= Constants.TESTDATAPATH;
		f=new FileInputStream(filePath);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		int y=(int) c.getNumericCellValue();//type casting
		return String.valueOf(y);
	}
	
	

}
