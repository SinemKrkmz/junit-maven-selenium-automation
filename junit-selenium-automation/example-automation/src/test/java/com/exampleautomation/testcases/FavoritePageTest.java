package com.exampleautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.exampleautomation.base.TestBase;
import com.exampleautomation.pages.HomePage;
import com.exampleautomation.pages.LoginPage;
import com.exampleautomation.pages.SearchPage;

import com.exampleautomation.util.TestUtil;
import com.exampleautomation.pages.FavoritePage;

public class FavoritePageTest  extends TestBase{
	
	static LoginPage loginPage;
	static HomePage homePage;
	static SearchPage searchPage;

	static FavoritePage favoritePage;

	public FavoritePageTest(){
		super();
	}
	
	@BeforeClass
	public static void setUp(){
		initialization();
		
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		searchPage = new SearchPage();
		favoritePage = new FavoritePage();
		
		
	}
	
	
	@Test()
	public  void test_1_AddFavorite(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage.Search(prop.getProperty("marka"));
		searchPage.searchPagingPageGo();
		favoritePage.addFavoriteProduct();
		favoritePage.goToFavoriteList();
		favoritePage.openToFavoriteList();
		Assert.assertEquals(favoritePage.favorite_product, favoritePage.third_product_name);
		
	}
	
	@Test()
	public void test_2_DeleteFavoriteTest() {
		favoritePage.deleteFavoriteProduct();
		
	}
	
	@Test
	public void test_2_2_deleteConfirmationForProduct () {
		
		Assert.assertTrue(favoritePage.deleteConfirmForProduct());
	
 
	}
		
	 	
		
	
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}

}
