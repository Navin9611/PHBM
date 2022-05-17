package com.hbm.ui.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.hbm.ui.teststeps.data.ClientData;
import com.hbm.ui.utilities.WebDriverUtil;

public class CreateClientPage {
	WebDriverUtil app;

	public CreateClientPage(WebDriverUtil app) {
		this.app = app;
	}

	public void submitClientDetails(List<ClientData> clientData) throws InterruptedException, AWTException {
		app.type("firstname.Box_xp", clientData.get(0).firstName);
		app.type("lastname.Box_xp", clientData.get(0).lastName);
		app.click("cancel.Button_xp");
		Thread.sleep(5000);
	}

}
