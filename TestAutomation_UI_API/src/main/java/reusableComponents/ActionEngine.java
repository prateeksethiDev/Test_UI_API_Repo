package reusableComponents;

import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import testBase.DriverFactory;
import testBase.ExtentFactory;


public class ActionEngine {
	
	WebDriver driver=DriverFactory.getInstance().getDriver();
	
	public void sendKeys(WebElement element,String fieldName,String valueToBeSent) {		
		
		try {
			element.sendKeys(valueToBeSent);
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" entered value as "+valueToBeSent+" is successful");
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" entered value as "+valueToBeSent+" is failed due to "+e.getMessage());
		}
	}
	
	public void click(WebElement element,String fieldName) {
		try {
			element.click();
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" click is successful");
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to click on field "+fieldName+" due to exception=>"+e.getMessage());
		}
	}
	
	public void clear(WebElement element,String fieldName) {
		try {
			element.clear();
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" clear is successful");
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to clear on field "+fieldName+" due to exception=>"+e.getMessage());
		}
	}
	
	public void moveToElement(WebElement element,String fieldName) {
		try {
			JavascriptExecutor executor=(JavascriptExecutor)DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true)", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());
			actions.moveToElement(element).build().perform();
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" Mouse Hovered successful");
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to Mouse Hovered on  "+fieldName+" due to exception=>"+e.getMessage());
		}
	}
	
	public boolean isElementPresent(WebElement element,String fieldName) {
		boolean flag=false;
		try {
			flag=element.isDisplayed();
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" Presence of field is successful");
			return flag;
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to check presence of field "+fieldName+" due to exception=>"+e.getMessage());
		}
		return flag;
	}
	
	public boolean isElementNotPresent(WebElement element,String fieldName) {
		boolean flag=false;
		try {
			flag=!element.isDisplayed()?true:false;
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" Presence of field is successful");
			return flag;
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to check presence of field "+fieldName+" due to exception=>"+e.getMessage());
		}
		return flag;
	}
	
	public void selectDropDownByVisibleText(WebElement element,String fieldName,String visibleText) {
		
		try {
			Select s = new Select(element);
			s.selectByVisibleText(visibleText);
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+" selected from dropdown is successful");
			
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" unable to select visibleText from dropdown "+fieldName+" due to exception=>"+e.getMessage());
		}
		
	}
	
	public void assertEqualsString(String expValue,String actualValue,String locatorName) {
		try {
			Assert.assertEquals(expValue, actualValue);
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, locatorName+" String assertion is successful");
			
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, locatorName+" String assertion is failed "+locatorName+" due to exception=>"+e.getMessage());
		}
	}
	
	public void assertConfirmationPopUp(String fieldName) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			
			
			//log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"Acceptance of Confirmation Popup is successful");
			
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" Acceptance of Confirmation Popup is "+fieldName+" due to exception=>"+e.getMessage());
		}
	}
	
	public void waitElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForElementToBeAccessible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),10);
		wait.until(new Function<WebDriver, WebElement>() 
	    {    
	        public WebElement apply(WebDriver driver) 
	        {    
	            return driver.findElement(locator);    
	        }
	    });
	}
	
	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForElementIneVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void assertWebElementNotPresent(By locator) {
		try {
			if(DriverFactory.getInstance().getDriver().findElements(locator).size()==0) {
				//log success message in extent report
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "WebElement with locator: "+ locator+" not present, validation is passed");
			}		
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "WebElement with locator: "+ locator+" is present, validation failed due to exception=>"+e.getMessage());
		}
	}
	
	public void assertWebElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),20);
			if(wait.until(ExpectedConditions.numberOfElementsToBe(locator, 1)).size()==1) {
				//log success message in extent report
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "WebElement with locator: "+ locator+" present, validation is passed");
			}		
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "WebElement with locator: "+ locator+" is not present, validation failed due to exception=>"+e.getMessage());
		}
	}
	
	public String getTextFromElement(By locator) {
		String text="";
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),20);
			if(wait.until(ExpectedConditions.numberOfElementsToBe(locator, 1)).size()==1) {
				text=DriverFactory.getInstance().getDriver().findElement(locator).getText();
				//log success message in extent report
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "WebElement with locator: "+ locator+" present, validation is passed");
			}		
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "WebElement with locator: "+ locator+" is not present, validation failed due to exception=>"+e.getMessage());
		}
		return text;
	}
	
	public String getTitleOfPage() {
		return driver.getTitle();
	}
	
	public void assertTheResult(boolean exp) {
		try {
			
			if(exp) {
				//log success message in extent report
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "Expression is evaluate to true, validation is passed");
			}		
		}catch(Exception e) {
			//log failure message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Expression is evaluate to false, validation is failed");
		}
	}
	
	public String returnDynamicXpath(String stringToReplace,String stringWithReplace) {
		return String.format(stringToReplace, stringWithReplace);
	}
}
