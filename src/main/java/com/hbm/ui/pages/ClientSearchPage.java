package com.hbm.ui.pages;

import org.openqa.selenium.WebDriver;

import com.hbm.ui.utilities.WebDriverUtil;

public class ClientSearchPage  {

	WebDriverUtil app;
	WebDriver driver;
	

	public ClientSearchPage(WebDriverUtil app) {
		this.app = app;
	}

	public void submitClientDetailsSearch() throws InterruptedException {
		app.type("search.Bar_xp", "Smith");
		Thread.sleep(5000);		
		app.click("client.Select_xp");
		Thread.sleep(10000);
	}

}
