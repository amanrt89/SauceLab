package Reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import LibrarryClass.Utility;
import net.bytebuddy.utility.RandomString;

public class ExtentReportListener implements ITestListener 
{
        public ExtentSparkReporter sparkReporter;   //UI of Report  (Look & Feel) 
        public ExtentReports extent;	//populate info to the report  eq:- ProjectName, ModuleName, tester name, browser name, OS
        public ExtentTest test;                //creating test case entries in reports & update status of test method

    public void onStart(ITestContext context)        //it creates report template at the start of execution
    { 
    	SimpleDateFormat sformat=new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
	    Date d=new Date();
	    String timestamp= sformat.format(d);
    	//String random= RandomString.make(5);
	    
	    
        sparkReporter = new ExtentSparkReporter("src/main/java/Reports/AutomationExetutionReport"+timestamp+".html");
        sparkReporter.config().setDocumentTitle("Automation Report");  //title of the report
        sparkReporter.config().setReportName("6th July Automation Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        extent.setSystemInfo("Envirnment:", "QA");
        extent.setSystemInfo("Browser Name:", "Chrome");
        extent.setSystemInfo("Test Engg Name: ", "Aman");
    }

    public void onTestSuccess(ITestResult result) 
    {
    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
        test.log(Status.PASS, "Test case is Passed: "+result.getName());    //update status
    }

    public void onTestFailure(ITestResult result)
    {
    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
        test.log(Status.FAIL, "Test case is Failed: "+result.getName());    //update status
        test.log(Status.FAIL, "Test case is Failed cause: "+result.getThrowable());  //get failure msg
        
    }

    public void onTestSkipped(ITestResult result)
    {
    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
        test.log(Status.SKIP, "Test case is Skipped: "+result.getName()); 
    }

    public void onFinish(ITestContext context) 
    {
        if (extent != null) {
            extent.flush();
        }
    }
}