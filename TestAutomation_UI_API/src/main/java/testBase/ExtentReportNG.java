package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import reusableComponents.PropertiesOperation;


public class ExtentReportNG {
	public static ExtentReports extent;
	
	public static ExtentReports setupReports() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate=format.format(date);
		String reportPath=System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualdate+".html";	
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");
		extent.setSystemInfo("Execeuted on Environment:", PropertiesOperation.getPropertyValueByKey("url"));
		extent.setSystemInfo("Execeuted on Browser:", PropertiesOperation.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Execeuted on OS:", System.getProperty("os.name"));
		extent.setSystemInfo("Execeuted on User:", System.getProperty("user.dir"));
		return extent;	
	}
}
