package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.prateek.automation.configuration.CommonConfig;
import com.prateek.automation.configuration.CommonConfigHandler;
import reusableComponents.ActionEngine;

public class TestBase extends ActionEngine{
	BrowserFactory bf = new BrowserFactory();
	//private static boolean skipFlag = false;

	
	public void launchApplication() throws Exception {
		CommonConfig commonConfig = CommonConfigHandler.buildConfig("config.properties");
		String browser=commonConfig.getAutomationConfig().browser();
		String url=commonConfig.getApplicationConfig().url();
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