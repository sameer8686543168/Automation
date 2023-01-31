package com.qa.bigbasket.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import basket.BigbasketFactoryPage;
import basket.Homepage;

public class Basetest {
	BigbasketFactoryPage b;
	//Page page;
	Page page;
	protected Properties prop;
	protected Homepage homepage;
	
	@BeforeTest
	public void setup() {
		b = new BigbasketFactoryPage();
		prop = b.init_prop();
		page=b.initbrowser(prop);
		homepage=new Homepage(page);
	}
	
	
	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}
	
	
}
