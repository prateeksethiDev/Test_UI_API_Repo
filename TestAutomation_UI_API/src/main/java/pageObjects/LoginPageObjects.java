package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase{
	
	
	By EMAIL=By.name("login[email]");
	By PASSWORD=By.name("login[password]");
	By LOGIN_BTN=By.xpath("//button[text()='Login ']");
	
	public void enterUserName(String email) {
		sendKeys(DriverFactory.getInstance().getDriver().findElement(EMAIL),"LoginEmailField",email);
	}
	
	public void enterPassword(String password) {
		sendKeys(DriverFactory.getInstance().getDriver().findElement(PASSWORD),"LoginEmailField",password);
	}
	
	public void clickLogin() {
		click(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN),"LoginButton");
	}
	
	
	//login to App
	public void login(String email,String password) {
		sendKeys(DriverFactory.getInstance().getDriver().findElement(EMAIL),"LoginEmailField",email);
		sendKeys(DriverFactory.getInstance().getDriver().findElement(PASSWORD),"LoginPasswordField",password);
		click(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN),"LoginButton");
	}
}
