package com.exampleautomation.testcases;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.exampleautomation.base.TestBase;
import com.exampleautomation.pages.HomePage;
import com.exampleautomation.pages.LoginPage;
import com.exampleautomation.pages.SearchPage;

public class SearchPageTest extends TestBase {
	static LoginPage loginPage;
	static HomePage homePage;
	static SearchPage searchPage;

	public SearchPageTest() {
		super();
	}

	@BeforeClass
	public static void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		searchPage = new SearchPage();

	}

	@Test()
	public void Test_1_search() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage.Search(prop.getProperty("marka"));
		Assert.assertEquals(searchPage.SearchListSuccess(), prop.getProperty("marka"));
	}

	@Test()
	public void Test_2_searchPaging() {

		searchPage.searchPagingPageGo();	
		Assert.assertEquals(searchPage.SearchPagingPageTitleTest(), "Samsung - n11.com - 2");
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
