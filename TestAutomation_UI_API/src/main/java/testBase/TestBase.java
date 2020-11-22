package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public String returnDynamicXpath(String stringToReplace,String stringWithReplace) {
		return String.format(stringToReplace, stringWithReplace);
	}
		
	
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}	
}