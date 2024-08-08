package phan20.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	public static ExtentReports getReportObject() {

		String path =  System.getProperty("user.dir" )+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation");
		reporter.config().setDocumentTitle("test results");
		
		ExtentReports	extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "thuhoai");
		return extent;
	}

}
