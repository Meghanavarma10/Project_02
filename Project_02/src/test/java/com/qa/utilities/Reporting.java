package com.qa.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentSparkReporter Reporter;
	public ExtentReports extent;
	public ExtentTest xTest;
	
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report" + timeStamp + ".html";
		
		String path=System.getProperty("user.dir")+"/ExtentReport/" +repName;
		Reporter= new ExtentSparkReporter(path);
		Reporter.config().setDocumentTitle("Automation Testing");
		Reporter.config().setReportName("Functional Testing");
		Reporter.config().setTheme(Theme.DARK);
	
		
		
		extent=new ExtentReports();
	    extent.attachReporter(Reporter);
		extent.setSystemInfo("Host Name","localhost");
		extent.setSystemInfo("QA Name","user");
		extent.setSystemInfo("OS","windows");
	
	
}
public void onFinish(ITestContext testContext) {
	extent.flush();
}

public void onTestSuccess(ITestResult tr) {
	xTest = extent.createTest(tr.getName());
	xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	xTest.log(Status.PASS,"Test is passed");
}

public void onTestFailure(ITestResult tr) {
	xTest = extent.createTest(tr.getName());
	xTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	xTest.log(Status.FAIL,"Test is failed");
	xTest.log(Status.FAIL,tr.getThrowable());
}


public void onTestSkipped(ITestResult tr) {
	
	xTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	xTest.log(Status.SKIP,"Test is skipped");
	xTest.log(Status.FAIL,tr.getThrowable());
}
	
}
	
	