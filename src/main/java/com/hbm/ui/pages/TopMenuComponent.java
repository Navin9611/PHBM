package com.hbm.ui.pages;

import com.hbm.ui.utilities.WebDriverUtil;

public class TopMenuComponent {

	WebDriverUtil app;

	public TopMenuComponent(WebDriverUtil app) {
		this.app = app;
	}

	public void clickCreate(String globalOption) throws InterruptedException {
		app.click("create.Button_xp");
	}

	public void clickClient(String menuClientOption) {
		app.click("client.Option_xp");
	}

	public void clickGroup(String menuGroupOption) throws InterruptedException {
		app.click("group.Option_xp");
	}
}
