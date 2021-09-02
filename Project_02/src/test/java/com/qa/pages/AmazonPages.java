package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	WebDriver driver;

	AmazonPages AmazonOR;

		@FindBy(id="searchDropdownBox") WebElement Category;

		public Select getCategory() {
			Select Cat= new Select(Category);
			return Cat;
		}

		@FindBy(id ="twotabsearchtextbox")WebElement SearchTextBox;
	public WebElement getSearchTextBox() {
		return SearchTextBox;
	}
		@FindBy(id="nav-search-submit-button")WebElement Magnifier; 
		
		public WebElement getMagnifier() {
			return Magnifier;
		}

		@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
		List<WebElement> ItemNames;

		public List<WebElement> getItemNames(){
			return ItemNames;
		}
	

		public AmazonPages(WebDriver driver) {
			this.driver=driver;
		}



		public void SearchItem(String string, String string2) {
			
		}

}
