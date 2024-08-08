package h.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import phan20.resources.extentReport;

public class Listeners extends baseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = extentReport.getReportObject();
	//tranh van de dong bo 
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	@Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub	
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
        		
    }		

    //method nay chi thuc thi khi thanh cong 
    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
    	 extentTest.get().log(Status.PASS, "Test passed");
    	
    }	
    @Override		
    public void onTestFailure(ITestResult result){		
    	//thong bao loi 
       extentTest.get().fail(result.getThrowable());
       //
       try {
		driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       //dinh kem hinh anh 
       String filePath=null;
       try {
		 filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }	
    @Override		
    public void onTestSkipped(ITestResult result) {					
  
        		
    }	
    @Override		
    public void onFinish(ITestContext result) {					
        extent.flush();				
        		
    }		

    @Override		
    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

	
	
	

}
