package com.hbm.ui.pages;

import java.awt.AWTException;
import java.util.List;
import com.hbm.ui.teststeps.data.CurrencyData;
import com.hbm.ui.utilities.WebDriverUtil;

public class MakeDepositPage {
	WebDriverUtil app;

	public MakeDepositPage(WebDriverUtil app) {
		this.app = app;
	}

	public void submitCurrecyDetails(List<CurrencyData> currencyData) throws InterruptedException, AWTException {
		// app.type("firstname.Box_xp", clientData.get(0).firstName);
		// app.type("lastname.Box_xp", clientData.get(0).lastName);
		Thread.sleep(5000);
	}

}
