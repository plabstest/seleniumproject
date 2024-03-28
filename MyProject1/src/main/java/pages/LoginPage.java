package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declare
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement passWord;
	
	@FindBy(id="login-button")
	private WebElement loginbtn;
	
	//intialize
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilize
	public void enterUsername(String name) {
		username.sendKeys(name);
	}
	public void enterPasswor(String password) {
		passWord.sendKeys(password);
	}
	public void clickLogin() {
		loginbtn.click();
	}
	
	

}
