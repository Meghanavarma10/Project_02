package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

public class Amazon_Search_002 {
	@Test
	public void Search() {
		WebDriver driver = TestBase.startBrowser("chrome","https://www.amazon.in/");
		AmazonPages Amazon  =PageFactory.initElements(driver, AmazonPages.class);
		Amazon.SearchItem("Books","Da vinci Code");

		Amazon.SearchItem("Electronics", "Mobile Phones");

		Amazon.SearchItem("Furniture", "Wooden Tables");
		Amazon.SearchItem("Clothing and Accessories", "Jeans");
	
	}
}
