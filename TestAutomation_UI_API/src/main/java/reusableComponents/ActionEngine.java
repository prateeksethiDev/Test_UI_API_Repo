package reusableComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import testBase.DriverFactory;
import testBase.ExtentFactory;


public class ActionEngine {
	
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

}
