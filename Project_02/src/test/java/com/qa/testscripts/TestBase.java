package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class TestBase {

	static WebDriver driver;

	public static WebDriver startBrowser(String browserName,String Url) {

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Meghana\\Desktop\\selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Meghana\\Desktop\\selenium software\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Url);
		

		return driver;
	}
	
	   @AfterClass
	    public void tearDown() {
	    	//close browser
	    	driver.close();
	    }
	
}
