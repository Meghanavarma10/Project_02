package com.qa.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Amazon_ExtentReport {
	public WebDriver driver;
	public ExtentSparkReporter htmlReporter;
	public ExtentReports XReports;
	public ExtentTest XTest;

	@BeforeTest
	public void StartReport() {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String Repname = "Test-execution-report"+ timeStamp + "html";
		 
		 String dest =System.getProperty("user.dir")+"/ExtentReport/"+ Repname;
		 
		 htmlReporter = new ExtentSparkReporter(dest);
		
	//	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\MyHTMLReport.html");
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);

		XReports = new ExtentReports();
		XReports.attachReporter(htmlReporter);
		XReports.setSystemInfo("HostName", "localhost");
		XReports.setSystemInfo("Browser", "chrome");


	}
	@AfterTest
	public void EndReport() {
		driver.quit();
		XReports.flush();
	}


	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Meghana\\Desktop\\selenium software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}
	@AfterMethod
	public void tearDown(ITestResult results) {

		if(results.getStatus()==ITestResult.FAILURE) {
			XTest.log(Status.FAIL,"The test Failed is "+ results.getName());
			XTest.log(Status.FAIL,"The test Failed is "+ results.getThrowable());
		}
		else if (results.getStatus()== ITestResult.SUCCESS) {
			XTest.log(Status.PASS,"The test Passed is"+ results.getName());
		}else if(results.getStatus()==ITestResult.SKIP) {
			XTest.log(Status.PASS,"The test Skipped is"+ results.getName());
		}





	}

}
