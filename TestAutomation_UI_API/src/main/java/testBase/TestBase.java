package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.Before;
import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperation;

public class TestBase extends ActionEngine{
	BrowserFactory bf = new BrowserFactory();
	//private static boolean skipFlag = false;

	
	public void launchApplication() throws Exception {
		
		String browser=PropertiesOperation.getPropertyValueByKey("browser");
		String url=PropertiesOperation.getPropertyValueByKey("url");
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		WebDriver driver=DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.get(url);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	
	
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
