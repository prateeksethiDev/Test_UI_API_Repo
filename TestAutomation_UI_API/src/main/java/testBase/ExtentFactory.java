package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	//ThreadLocal-->java.lang -- MultiThreading--Threadlocal not shares the state of the object with other thread-- impact performance
	
		//singleton design pattern
		private ExtentFactory() {
			
		}
		
		private static ExtentFactory instance = new ExtentFactory();
		public static ExtentFactory getInstance() {
			return instance;
		}
		
		//Factory design Pattern
		ThreadLocal<ExtentTest> extent = new ThreadLocal<>();
		
		public ExtentTest getExtent() {
			return extent.get();
		}
		
		public void setExtent(ExtentTest exteentTestObj) {
			extent.set(exteentTestObj);
		}
		
		public void removeExtentObject() {
			extent.remove();
		}
}
