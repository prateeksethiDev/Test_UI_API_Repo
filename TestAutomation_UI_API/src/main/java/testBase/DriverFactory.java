package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	
	//ThreadLocal-->java.lang -- MultiThreading--Threadlocal not shares the state of the object with other thread-- impact performance
	
	//singleton design pattern
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance = new DriverFactory();
	public static DriverFactory getInstance() {
		return instance;
	}
	
	//Factory design Pattern
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
}
