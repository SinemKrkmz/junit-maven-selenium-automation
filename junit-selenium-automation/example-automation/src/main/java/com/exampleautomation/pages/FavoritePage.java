package com.exampleautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exampleautomation.base.TestBase;

public class FavoritePage extends TestBase {
	public String favorite_product = "";
	public String third_product_name;

	@FindBy(xpath = "//li[3]/div/div[2]/span[2]")
	private WebElement thirdProductInList;
	
	//İkinci Sayfadaki 3. ürünün ismini alır
	@FindBy(xpath = "//*[@id=\"view\"]/ul/li[3]/div/div/a/h3")
	private WebElement thirdProductName;
    
	//Favorilere Ekleme 
	@FindBy(xpath = "//*[@class=\"listView \"]/ul/li[3]/div/div[2]/span[2]")
	private WebElement favoriAddButton;
    
	//Favori sayfasını açar
	@FindBy(xpath = "//*[@class='myAccountMenu hOpenMenu']/div[1]/a[2]")
	private WebElement linkFavoriteList;
    
	// Favori ürünleri açar
	@FindBy(xpath = "//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a")
	private WebElement openFavoriteList;

	@FindBy(xpath = "//*[@class=\"columnContent adBg\"]/div[1]/a/h3")
	private WebElement firstFavoriteProduct;

	@FindBy(xpath = "//*[@class=\"columnContent adBg\"]/div[3]/span")
	private WebElement deleteFavoriteButton;

	@FindBy(xpath = "/html/body/div[5]/div/div/span")
	private WebElement deleteOkButton;

	@FindBy(xpath = "//*[@class=\"emptyWatchList\"]")
	private WebElement emptyFavoriteText;
	@FindBy(xpath = "//* [@id='view']/ul/li/div/div/a/h3")
	private List<WebElement> productTitles;

	public FavoritePage() {
		PageFactory.initElements(driver, this);

	}

	public void selectThirdProduct() {
		setFavoriteProduct();
		thirdProductInList.click();
		favoriAddButton.click();
	}

	public String setFavoriteProduct() {
		third_product_name = thirdProductName.getText();
		
		return third_product_name;
		

	}

	public void addFavoriteProduct() {
		setFavoriteProduct();
		favoriAddButton.click();
	}

	public void goToFavoriteList() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", linkFavoriteList);
		
	}

	public void openToFavoriteList() {

		JavascriptExecutor jsl = (JavascriptExecutor) driver;
		jsl.executeScript("arguments[0].click();",openFavoriteList);
		getFavoriteProduct();
	}

	public void getFavoriteProduct() {
		JavascriptExecutor jsl = (JavascriptExecutor) driver;
		favorite_product = (String)jsl.executeScript("return arguments[0].innerText",firstFavoriteProduct);
		
	}

	public void deleteFavoriteProduct() {
		JavascriptExecutor jsl = (JavascriptExecutor) driver;
		jsl.executeScript("arguments[0].click();",deleteFavoriteButton);
		deleteOkButton.click();

	}
	
	public List<WebElement> myFavoriteList() {
		return productTitles;
	}

	public boolean deleteConfirmForProduct() {

		boolean controlValue = false;
		Integer count = 0;
		count = myFavoriteList().size();
       
		if (count == 1) {
			 controlValue=true;
		} else {
		    
			for (WebElement productTitle : myFavoriteList()) {   
				String watchesProduct=productTitle.getText(); 
				
				if (watchesProduct.equals(favorite_product)) 
					controlValue= true;
			} 
			
			
			
			
			
		}
		return controlValue;
	}

}
