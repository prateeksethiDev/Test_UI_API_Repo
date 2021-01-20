package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.prateek.automation.configuration.CommonConfig;
import com.prateek.automation.configuration.CommonConfigHandler;
import reusableComponents.ActionEngine;

public class TestBase extends ActionEngine{
	BrowserFactory browserFactory = new BrowserFactory();
	//private static boolean skipFlag = false;

	
	public void launchApplication() throws Exception {
		CommonConfig commonConfig = CommonConfigHandler.buildConfig("config.properties");
		String browser=commonConfig.getAutomationConfig().browser();
		String url=commonConfig.getApplicationConfig().url();
		String execution_mode=commonConfig.getAutomationConfig().execution_mode();
		DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browser,execution_mode));
		WebDriver driver=DriverFactory.getInstance().getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//To-Do remove implicit wait
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