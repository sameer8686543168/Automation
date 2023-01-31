package com.qa.basket.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.basket.constants.AppConstants;
import com.qa.bigbasket.base.Basetest;

public class HomePageTest extends Basetest {
	
	
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String actualTitle = homepage.getHomepagetitle();
		Assert.assertEquals(actualTitle,AppConstants.HOME_PAGE_TITLE );
	}
	
	@Test(priority = 2)
	public void homePageUrlTest() {
		String actualURL =homepage.gethomeopageurl();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getproviderdata() {
		return new  Object[][] {
			{"fruits"},
			{"banana"},
			{"Apple"},
			{"Watermelon"},
			{"mango"}
		};
	}
	
	@Test(priority = 3, dataProvider = "getproviderdata")
	public void searchTest(String productname) {
		String actualSearchPageURL = homepage.dosearch(productname);
		Assert.assertEquals(actualSearchPageURL, "https://www.bigbasket.com/ps/?q="+productname);
	}
	
	
}
