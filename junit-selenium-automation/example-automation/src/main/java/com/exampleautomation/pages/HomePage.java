package com.exampleautomation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exampleautomation.base.TestBase;

public class HomePage extends TestBase {


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		
		return  driver.getTitle();
	}

	
	
	
	
	
	
	
	
	
	
	

}
