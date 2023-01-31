package basket;

import com.microsoft.playwright.Page;

public class Homepage {
	  private Page page;
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
		String title = page.title();
		System.out.println(title);
		return title;
	}
	public String gethomeopageurl() {
		String url = page.url();
		System.out.println(url);
		return url;
	}
	public String dosearch(String productname) {
		page.fill(search, productname);
		page.click(searchicon); 
	    String content=	page.textContent(pageHeader);
	    System.out.println(content);
		return page.url();
	}
	

}
