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
	By logIn_Link=By.id("login2");
	By userName_Inp=By.id("loginusername");
	By password_Inp=By.id("loginpassword");
	By LogIn_Btn=By.xpath("//button[text()='Log in']");
	By welcome_User_Link=By.xpath("//li/a[text()='Welcome user2@testemail.com']");
			
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

		public void login() {
			if(driver.findElements(welcome_User_Link).size()>0) {
				clickOnHomeMenu();
			}else {
			click(driver.findElement(logIn_Link),"Login Link");
			sendKeys(driver.findElement(userName_Inp),"UserName","user2@testemail.com");
			sendKeys(driver.findElement(password_Inp),"Password","testqa");
			click(driver.findElement(LogIn_Btn), "Login Button");
			}
		}
		
		
}
