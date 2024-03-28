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

import pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername("standard_user");
		login.enterPasswor("secret_sauce");
		login.clickLogin();
		
		String actual_title = driver.getTitle();
		String exp_title = "Swag Labs";
		if(actual_title.equalsIgnoreCase(exp_title)){
			System.out.println("Title matches");
		}
		else
			System.out.println("Title mismatch");
		
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		By ele = By.id("logout_sidebar_link");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		
		logout.click();
		System.out.println("logged out");
		//driver.close();
		driver.quit();

	}

}
