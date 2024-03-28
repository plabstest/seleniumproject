package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Utils {
	public static String getPropertyValue(String path,String key) {
		Properties prop = new Properties();
		try {
			prop.load( new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		return value;	
}
	
	public static WebDriver openBrowser(WebDriver driver,String browser) {
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
			return driver;
		 
	}
	
	public static String getScreenshot(WebDriver driver) {
		Date d = new Date();
		String dateTime = d.toString().replaceAll(":","_");
		String path="./screenshots/"+dateTime+".png";
		TakesScreenshot pic = (TakesScreenshot)driver;
		File source = pic.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(source, dest);
			Reporter.log("<a href='"+dest.getAbsoluteFile()+"'><img src='"+dest.getAbsoluteFile()+"' /a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	
	public static String getXLData(String path,String sheetname,int row,int col) {
		String val="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			 val= w.getSheet(sheetname).getRow(row).getCell(col).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	
	public static int getXLRowCount(String path,String sheetname) {
		int rows=0;
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			 rows = w.getSheet(sheetname).getLastRowNum();
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;

	}

}
