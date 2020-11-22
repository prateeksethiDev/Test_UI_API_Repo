package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testBase.DriverFactory;
import testBase.TestBase;

public class CartPageObjects extends TestBase{
	
	WebDriver driver=null;

	public CartPageObjects() {
		driver=DriverFactory.getInstance().getDriver();
	}

	By cart_ProductLabel_Label=By.xpath("//div[@class='table-responsive']/preceding::h2[text()='Products']");
	String dynamicXpathStr_ProductGridItem="//div[@class='table-responsive']/descendant::tr[@class='success']/child::td[text()='%s']";
	
	
	public void validateUserOnCartPage() {
		isElementPresent(driver.findElement(cart_ProductLabel_Label),"Cart product Label");
	}
	
	public void validateItemAddedOnCart(String itemName) {
		waitForElementToBeVisible(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName)));
		isElementPresent(driver.findElement(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName))), itemName+" product in cart");
	}
	

}
