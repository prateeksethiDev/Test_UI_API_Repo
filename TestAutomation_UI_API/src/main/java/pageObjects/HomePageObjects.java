package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.TestBase;

public class HomePageObjects extends TestBase{
	
	WebDriver driver=null;
	By sidebarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");
	
		
		public void clickOnSideMenu(String menu) {
			String xpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
			DriverFactory.getInstance().getDriver().findElement(By.xpath(xpath)).click();
		}
		
		public void clickOnSideSubMenu(String menu,String submenu) {
			String menuXpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
			DriverFactory.getInstance().getDriver().findElement(By.xpath(menuXpath)).click();
			String submenuXpath="//ul[@class='page-sidebar-menu']//li/a/i/following-sibling::span[text()='Tasks']/ancestor::a/following-sibling::ul//span[text()='"+submenu+"']";
			DriverFactory.getInstance().getDriver().findElement(By.xpath(submenuXpath)).click();
		}
		
		public void checkIfDashboardPageIsOpen() {
			Assert.assertTrue(isElementPresent(DriverFactory.getInstance().getDriver().findElement(sidebarMenu_Dashboard), "DashBoard Menu"));
			
		}
}
