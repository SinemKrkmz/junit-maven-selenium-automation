package com.exampleautomation.testcases;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.exampleautomation.base.TestBase;
import com.exampleautomation.pages.HomePage;
import com.exampleautomation.pages.LoginPage;

public class LoginPageTest extends TestBase{
	static LoginPage loginPage;
	static HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public static void setUp(){
		initialization();
		loginPage = new LoginPage();	
		
	}
	
	
	
	@Test()
	public void Test_1_loginSuccesfull(){
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String fullName = loginPage.validateLoginPage();
		Assert.assertEquals(fullName, prop.getProperty("fullname"));
	}
	
	

	

	
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}
	
	
	
	

}
