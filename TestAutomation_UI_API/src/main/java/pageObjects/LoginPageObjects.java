package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.ActionEngine;
import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends ActionEngine{
	
	WebDriver driver=null;
	public LoginPageObjects() {
		driver=DriverFactory.getInstance().getDriver();
	}

	By LOGIN_LABEL=By.xpath("//h5[@id='logInModalLabel']");
	By EMAIL=By.id("loginusername");
	By PASSWORD=By.id("loginpassword");
	By LOGIN_BTN=By.xpath("//button[text()='Log in']");
	By logIn_Link=By.id("login2");
	
	public void enterUserName(String email) {
		sendKeys(driver.findElement(EMAIL),"LoginEmailField",email);
	}
	
	public void enterPassword(String password) {
		sendKeys(driver.findElement(PASSWORD),"LoginEmailField",password);
	}
	
	public void clickLogin() {
		click(driver.findElement(LOGIN_BTN),"LoginButton");
	}
	
	
	//login to App
	public void login(String email,String password) {
		assertWebElementPresent(EMAIL);
		sendKeys(driver.findElement(EMAIL),"LoginEmailField",email);
		sendKeys(driver.findElement(PASSWORD),"LoginPasswordField",password);
		click(driver.findElement(LOGIN_BTN),"LoginButton");
	}
	
	public void verifyUserIsOnLoginPage() {
		assertWebElementPresent(logIn_Link);
	}
	
	public String getTitleOfLoginPage() {
		return driver.getTitle();
	}

	public void verifyTitleOfLoginPage(String pageTitle) {
		assertTheResult(driver.getTitle().trim().equalsIgnoreCase(pageTitle));		
	}
	
	public void clickOnLoginLink() {
		click(driver.findElement(logIn_Link),"Login Link");
	}
	public void verifyLoginLabel() {
		assertWebElementPresent(LOGIN_LABEL);
	}
}
