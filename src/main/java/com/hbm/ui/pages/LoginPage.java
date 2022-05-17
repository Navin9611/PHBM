package com.hbm.ui.pages;

import com.hbm.ui.utilities.WebDriverUtil;

public class LoginPage {
	WebDriverUtil app;

	public LoginPage(WebDriverUtil app) {
		this.app = app;
	}

	public void doLogin() throws InterruptedException {		
		
		app.openBrowser(app.getProperty("Browser"));
		app.navigate("url");
		if (!app.verifyTitle("ht"))
			app.logFailure("Title didn't Match", false);
		app.type("username.Box_xp", app.getProperty("userid"));
		app.type("password.Box_xp", app.getProperty("password"));
		app.click("login.Button_xp");
		app.log("Successfully Logged Into MAMBU");
		Thread.sleep(5000);
	}

	public void gotoLoginPage() throws InterruptedException {

	}

	public void gotoLogout() throws InterruptedException {
		app.click("logout.Button_xp");
		Thread.sleep(2000);
	}

}
