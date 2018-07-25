package com.exampleautomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exampleautomation.base.TestBase;
import com.exampleautomation.pages.HomePage;

public class LoginPage extends TestBase {
   
	// Page Factory - OR:
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]/a[2]")
	WebElement userFullName;
	
	@FindBy(xpath ="//*[@class=\"btnSignIn\"]")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"loginButton\"]")
	WebElement signUpBtn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	

	// Actions:
	public String validateLoginPage() {
		return userFullName.getText();
	}

	public HomePage login(String un, String pwd) {
		JavascriptExecutor jsl = (JavascriptExecutor) driver;
		jsl.executeScript("arguments[0].click();", loginBtn);
		
		username.sendKeys(un);
		password.sendKeys(pwd);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signUpBtn);

		return new HomePage();
	}

}
