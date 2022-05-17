package com.hbm.ui.teststeps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import com.hbm.ui.context.TestContext;
import com.hbm.ui.pages.ClientSearchPage;
import com.hbm.ui.pages.LoginPage;
import com.hbm.ui.pages.MakeDepositPage;
import com.hbm.ui.teststeps.data.CurrencyData;

public class DepositNavigation {

	public TestContext context;
	public ClientSearchPage clientSearchPage;
	public MakeDepositPage makeDepositPage;
	public LoginPage loginPage;

	public DepositNavigation(TestContext context) {
		this.context = context;
		this.loginPage = context.getPageObjectManager().getLoginPage();
		this.makeDepositPage = context.getPageObjectManager().getMakeDepositPage();
		this.clientSearchPage = context.getPageObjectManager().getClientSearchPage();
	}

	@After
	public void after(Scenario scenario) throws InterruptedException {
		loginPage.gotoLogout();
		context.getPageObjectManager().getWebDriverUtil().quit();
	}

	@And("Search for Client")
	public void search_for_client() throws Throwable {
		clientSearchPage.submitClientDetailsSearch();
	}

	@And("click on Client")
	public void click_on_client() throws Throwable {

	}

	@And("click on Branch Banking Member")
	public void click_on_branch_banking_member() throws Throwable {

	}


	@And("Click on Deposit Tab")
	public void click_on_deposit_tab() throws Throwable {

	}

}
