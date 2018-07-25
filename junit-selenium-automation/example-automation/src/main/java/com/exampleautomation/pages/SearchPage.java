package com.exampleautomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exampleautomation.base.TestBase;

public class SearchPage extends TestBase {
	// Page Factory - OR:
		@FindBy(id = "searchData")
		WebElement searchText;
		
		
		@FindBy(xpath ="//*[@class=\"searchBtn\"]")
		WebElement searchBtn;
		
		@FindBy(xpath="//*[@class=\"resultText\"]")
		WebElement resultText;
		
		@FindBy(xpath ="//*[@class='pagination']/a[2]")
		WebElement secondButton;
		
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Action
		public  void Search(String search) {
			searchText.sendKeys(search);
			JavascriptExecutor jsl = (JavascriptExecutor) driver;
			jsl.executeScript("arguments[0].click();", searchBtn);
		}
        
		public String SearchListSuccess() {
			
			JavascriptExecutor jsl = (JavascriptExecutor) driver;
			String result =(String)jsl.executeScript("return document.getElementsByClassName(\"resultText\")[0].getElementsByTagName(\"H1\")[0].innerText;");
			
			
			
			return result;
		}
		public void searchPagingPageGo() {
			secondButton.click();
		}
		
		public String SearchPagingPageTitleTest(){ 
			String[] parts = driver.getTitle().split("/");
			return parts[0];
			
		}
}
