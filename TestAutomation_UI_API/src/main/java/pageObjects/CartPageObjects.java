package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reusableComponents.ActionEngine;
import testBase.DriverFactory;
import testBase.TestBase;

public class CartPageObjects extends ActionEngine{
	
	WebDriver driver=null;

	public CartPageObjects() {
		driver=DriverFactory.getInstance().getDriver();
	}

	By cart_ProductLabel_Label=By.xpath("//div[@class='table-responsive']/preceding::h2[text()='Products']");
	String dynamicXpathStr_ProductGridItem="//div[@class='table-responsive']/descendant::tr[@class='success']/child::td[text()='%s']";
	String dynamicXpathStr_deleteLinkForProduct="//div[@class='table-responsive']/descendant::tr[@class='success']/child::td[text()='%s']/following-sibling::td/a[text()='Delete']";
	By placeOrder_Btn=By.xpath("//button[text()='Place Order']");
	By placeOrderWindow=By.id("orderModalLabel");
	By customerName_txt=By.xpath("//input[text()='name']");
	By Country_txt=By.id("country");
	By City_txt=By.id("city");
	By credit_card_number_txt=By.id("card");
	By month_txt=By.id("month");
	By year_txt=By.id("year");
	By purchase_Btn=By.xpath("//button[text()='Purchase']");
	By orderConfirmationMessage=By.xpath("//p[@class='lead text-muted ']");
	By orderConfirmOk_Btn=By.xpath("//button[text()='OK']");
	
	public void validateUserOnCartPage() {
		isElementPresent(driver.findElement(cart_ProductLabel_Label),"Cart product Label");
	}
	
	public void validateItemAddedOnCart(String itemName) {
		waitForElementToBeVisible(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName)));
		isElementPresent(driver.findElement(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName))), itemName+" product in cart");
	}

	public void deleteProductFromCart(String itemName) {
		waitForElementToBeVisible(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName)));
		click(driver.findElement(By.xpath(returnDynamicXpath(dynamicXpathStr_deleteLinkForProduct,itemName))),"Delete Product Link");		
	}
	
	public void validateDeletedFromCart(String itemName) {
		waitForElementIneVisible(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName)));
		assertWebElementNotPresent(By.xpath(returnDynamicXpath(dynamicXpathStr_ProductGridItem,itemName)));
	}
	
	public void clickOnPlaceOrderButton() {
		click(driver.findElement(placeOrder_Btn), "Place Order Button");
		assertWebElementPresent(placeOrderWindow);
	}
	
	public void enterName(String customer_name) {
		sendKeys(driver.findElement(customerName_txt), "CustomerName", customer_name);
	}
	public void enterCountry(String country) {
		sendKeys(driver.findElement(Country_txt), "Country", country);
	}
	public void enterCity(String City) {
		sendKeys(driver.findElement(City_txt), "City", City);
	}
	public void enterCreditCard(String Ccredit_card_number) {
		sendKeys(driver.findElement(credit_card_number_txt), "Ccredit_card_number", Ccredit_card_number);
	}
	public void enterMonth(String month) {
		sendKeys(driver.findElement(month_txt), "Month", month);
	}
	public void enterYear(String year) {
		sendKeys(driver.findElement(year_txt), "Year", year);
	}
	
	public void clickPurchaseBtn() {
		click(driver.findElement(purchase_Btn), "Purcase Button");
	}
	
	public void assertConfirmationMessageExists() {
		waitForElementToBeVisible(orderConfirmationMessage);
		assertWebElementPresent(orderConfirmationMessage);
	}
	
	public boolean validateOrderConfirmationMessage(String message) {
		String [] arr=getTextFromElement(orderConfirmationMessage).split("\\n");
		System.out.println("Order id is: "+arr[0]);
		System.out.println("Amount is: "+arr[1]);
		return arr[1].trim().equals(message)?true:false;
	}
	
	public void clickOrderConfirmationBtn() {
		click(driver.findElement(orderConfirmOk_Btn), "Ok Button");
	}
}

