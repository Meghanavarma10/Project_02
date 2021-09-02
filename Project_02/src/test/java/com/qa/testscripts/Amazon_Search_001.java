package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;
import com.qa.utilities.ExcelUtility;

public class Amazon_Search_001 extends TestBase{

	WebDriver driver = TestBase.startBrowser("chrome", "https://www.amazon.in/");
	AmazonPages Amazon = PageFactory.initElements(driver, AmazonPages.class);

	@Test(dataProvider = "getData")
	public void SearchItem(String Category, String ItemName) {

		Amazon.getCategory().selectByVisibleText(Category);
		Amazon.getSearchTextBox().clear();
		Amazon.getSearchTextBox().sendKeys(ItemName);
		Amazon.getMagnifier().click();

	}

	@DataProvider
	public String[][] getData() throws Exception {

		String xFile = "C:\\Users\\Meghana\\Downloads\\Selenium.Project\\src\\test\\java\\com\\qa\\testdata\\Inputdata.xlsx";
		String xSheet = "Sheet1";

		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);

			}

		}
		return data;
	}

}
