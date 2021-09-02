package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class Screenshot {

	 public  WebDriver driver;
	
	   @BeforeClass 
	    public void initilalization() {
	    	   //Opening browser
	    	
	    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Meghana\\Desktop\\selenium software\\chromedriver.exe");
	    	    driver = new ChromeDriver();
	    	    driver.get("https://www.amazon.in/");
	    	    driver.manage().window().maximize();	
	    	    
	    }
	   
	   @AfterClass
	    public void tearDown() {
	    	//close browser
	    	driver.close();
	    }
	   
	   @Test(priority=1)
	   public void screenshotOfElement() throws IOException {
		  File Source =  driver.findElement(By.id("nav-logo-sprites")).getScreenshotAs(OutputType.FILE);
		  String Dest = System.getProperty("user.dir")+"/Screenshot/"+"AmazonLogo.png";
		  FileUtils.copyFile(Source,new File(Dest));
		  
		  
	   }
	   @Test(priority=2)
	   public void screenshotOfDriver() throws IOException {
		   
		   TakesScreenshot screenshot = (TakesScreenshot) driver;
		   File Source = screenshot.getScreenshotAs(OutputType.FILE);
		   String Dest = System.getProperty("user.dir")+"/Screenshot/"+"AmazonPage.png";
		   FileUtils.copyFile(Source,new File(Dest));
	   }
	   
	   @Test(priority=3)
	   public void screenshotOfFullPage() throws IOException {
		  AShot SShot = new AShot();
		   ru.yandex.qatools.ashot.Screenshot Source = SShot.shootingStrategy(ShootingStrategies.viewportPasting(300)).takeScreenshot(driver);
		   String Dest = System.getProperty("user.dir")+"/Screenshot/"+"AmazonFullPage.jpg";
		   ImageIO.write(Source.getImage(),"jpg", new File(Dest));
}
	   }

