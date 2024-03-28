package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(Result.class)
public class BaseClass implements Iconstant{

	static {
		System.setProperty(chrome_key, chrome_value);
	}
	//declared the driver reference
	protected WebDriver driver ;
	String url= Utils.getPropertyValue(config_path, "URL");
	String browser= Utils.getPropertyValue(config_path, "browser");
	String ITO= Utils.getPropertyValue(config_path, "ITO");
	
		

	@BeforeTest
	public void openApp() {
	
	 driver = Utils.openBrowser(driver, browser);
	 Reporter.log("Browser is opened");
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void testResult(ITestResult result) {
		//to add results to testng report
		Reporter.setCurrentTestResult(result);
		String name = result.getName();
		int status = result.getStatus();
		// means failure
		if(status==2) {
			//take screenshot
			String path = Utils.getScreenshot(driver);
			Reporter.log("Test "+ name+ " is failed and screenshot is captured in "+path,true);
		}
		else {
			//log it pass
			Reporter.log("Test "+ name+ " is Passed",true);
		}
	}
	
	@AfterTest
	public void closeBrowser() {
	//driver.close();
	driver.quit();
	 Reporter.log("Browser is closed");
	}

}
