package com.exampleautomation.testcases;

import com.exampleautomation.pages.HomePage;
import com.exampleautomation.pages.LoginPage;
import com.exampleautomation.util.TestUtil;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;

import com.exampleautomation.base.TestBase;

public class HomePageTest extends TestBase {
	static LoginPage loginPage;
	static HomePage homePage;
	static TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public static void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test()
	public void Test_1_verifyHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "n11.com - Alışverişin Uğurlu Adresi");
	}



	

	@AfterClass
	public  static void tearDown() {
		driver.quit();
	}

}
