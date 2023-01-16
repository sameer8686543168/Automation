package basket;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BigbasketFactoryPage {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	public Page initbrowser(String browsername) {
		System.out.println(browsername);
		playwright = Playwright.create();
		
		switch (browsername.toLowerCase()) {
		case "chromium":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("Enter the Correct browser");
			break;
		}
			
			browserContext= browser.newContext();
		    page = browserContext.newPage();
		    page.navigate("https://www.bigbasket.com/");
		    return page;
		    
		
		}
		

	}
	

