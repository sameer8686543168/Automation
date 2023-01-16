package basket;

import com.microsoft.playwright.Page;

public class Homepage {
	 Page page;
	//1. String Locators
	private String search = "input#input";
	private String searchicon ="button[type=submit]";//"i.icon.svg-header.svg-search.svg-search-dim.hidden-sm.hidden-xs";
	private String pageHeader ="h2[qa='pageName']";
	
	//2. page constructor:  to invoke the above String Locators or Objects 
	public Homepage(Page page) {
		this.page = page;
	}
	//3.page methods
	public String getHomepagetitle() {
		return page.title();
	}
	public String gethomeopageurl() {
		return page.url();
	}
	public String dosearch(String productname) {
		page.fill(search, productname);
		page.click(searchicon); 
		return page.url();
	}
	

}
