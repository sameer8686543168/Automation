package com.qa.basket.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import basket.BigbasketFactoryPage;
import basket.Homepage;

public class HomePageTest {
	
	BigbasketFactoryPage b;
	//Page page;
	Page page;
	Homepage homepage;
	
	@BeforeTest
	public void setup() {
		b = new BigbasketFactoryPage();
		page=b.initbrowser("chrome");
		homepage=new Homepage(page);
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String actualTitle = homepage.getHomepagetitle();
		Assert.assertEquals(actualTitle, "Online Grocery Shopping and Online Supermarket in India - bigbasket");
	}
	
	@Test(priority = 2)
	public void homePageUrlTest() {
		String actualURL =homepage.gethomeopageurl();
		Assert.assertEquals(actualURL, "https://www.bigbasket.com/");
	}
	
	@Test(priority = 3)
	public void searchTest() {
		String actualSearchPageURL = homepage.dosearch("fruits");
		Assert.assertEquals(actualSearchPageURL, "https://www.bigbasket.com/ps/?q=fruits");
	}
	
	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}
	
	

}
