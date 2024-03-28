package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.BaseClass;
import common.Iconstant;
import common.Utils;
import pages.LoginPage;

public class DataDriven implements Iconstant{

		
//		@Test(priority=2)
//		public void readDataFromXL() {
//			
//		String user_name= Utils.getXLData(input_path,"Sheet",1,0);
//		String pass_word= Utils.getXLData(input_path,"Sheet",1,1);
//		
//		System.out.println("username is " +user_name);
//		System.out.println("password is " +pass_word);
//		}
		
//		@Test(priority=1)
//		public void getXLCount() {
//			int rowcount = Utils.getXLRowCount(input_path, "Sheet");
//			System.out.println("Total rows "+ rowcount);
//		}
		
		
		@Test
		public void getXLData() {
			int rowcount = Utils.getXLRowCount(input_path, "Sheet");
			int columns=2;
			for(int i=1;i<=rowcount;i++) {
				for(int j =0;j<columns;j++) {
					String value= Utils.getXLData(input_path,"Sheet",i,j);
					System.out.println(value);
				}
			}
		}

}
