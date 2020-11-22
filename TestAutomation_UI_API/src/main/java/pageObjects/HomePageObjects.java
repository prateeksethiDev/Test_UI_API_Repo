package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects extends TestBase{
	WebDriver driver=null;
	
	
	public HomePageObjects() {
		driver=DriverFactory.getInstance().getDriver();
	}

	By sidebarMenu_Categories = By.xpath("//a[@class='list-group-item'][text()='CATEGORIES']");
	By navigation_Home_Link=By.xpath("//a[@class='nav-link'][text()='Home ']");
	By sidebarmenu_Laptops=By.xpath("//div[@class='list-group']/child::a[text()='Laptops']");
	String dynamicItemXpathStr="//div[@class='col-lg-9']/div[@class='row']/descendant::a[text()='%s']";
	By addToCart_Btn=By.xpath("//a[text()='Add to cart']");
	By navigation_Cart_Link=By.xpath("//a[@class='nav-link'][text()='Cart']");
	
	
			
		public void clickOnHomeMenu() {
			waitElementToBeClickable(navigation_Home_Link);
			click(driver.findElement(navigation_Home_Link),"Navigation home Link");
		}
				
		public void checkIfHomePageIsOpen() {
			Assert.assertTrue(isElementPresent(driver.findElement(sidebarMenu_Categories), "Home Page"));		
		}
		
		public void clickOnLaptopsCategory() {
			click(driver.findElement(sidebarmenu_Laptops),"Sidebar Categories Laptops");
		}
		
		public void selectLaptop(String itemName) {
			click(driver.findElement(By.xpath(returnDynamicXpath(dynamicItemXpathStr,itemName))),"Click "+itemName+" from Laptops");
		}
		
		public void clickOnAddToCart() {
			click(driver.findElement(addToCart_Btn),"Add to cart button");
			assertConfirmationPopUp("Addition of product confirmation");			
		}
		
		public void clickOnCartMainMenu() {
			click(driver.findElement(navigation_Cart_Link),"Cart Main Menu Link");
		}
}
