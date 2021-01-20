package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	Logger logger = Logger.getLogger(BrowserFactory.class.getName());
	//create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser, String execution_mode) {
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.setAcceptInsecureCerts(true);
			if(execution_mode.equalsIgnoreCase("local")) {
			driver = new ChromeDriver(options);
			}else {
			try {
				driver=new RemoteWebDriver(new URL("http://192.168.64.3:30001/wd/hub"),options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			}
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions=new FirefoxOptions();
			foptions.addArguments("-private");
			foptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(foptions);
			
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ioptions= new InternetExplorerOptions();
			ioptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(ioptions);
		}else {
			logger.warning("Please pass the correct browser: "+browser);
		}
		return driver;
	}
}
