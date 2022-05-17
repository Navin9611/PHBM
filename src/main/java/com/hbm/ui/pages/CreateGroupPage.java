package com.hbm.ui.pages;
import com.hbm.ui.utilities.WebDriverUtil;


public class CreateGroupPage {
	WebDriverUtil app;
	
	public CreateGroupPage(WebDriverUtil app) {
		this.app = app;
	}

	public void submitGroupDetails() throws InterruptedException {
		app.type("groupname.Box_xp","TestGroup");
		Thread.sleep(5000);
		app.click("cancel.Button_xp");
		Thread.sleep(2000);
	
	}

}
