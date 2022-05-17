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
import com.hbm.ui.pages.CreateClientPage;
import com.hbm.ui.teststeps.data.ClientData;
import com.hbm.ui.pages.TopMenuComponent;

public class CreateClient {

	public TestContext context;
	public CreateClientPage createClientPage;
	public TopMenuComponent topMenu;

	public CreateClient(TestContext context) {
		this.context = context;
		this.createClientPage = context.getPageObjectManager().getCreateClientPage();
		this.topMenu = context.getPageObjectManager().getTopMenu();

	}

	@Before
	public void before(Scenario scenario) {
		context.createScenario(scenario.getName());
		context.log("Starting Scenario : " + scenario.getName());
	}

	@After
	public void after(Scenario scenario) {
		context.log("Ending Scenario : " + scenario.getName());
		context.endScenario();
		context.getPageObjectManager().getWebDriverUtil().quit();
	}

	// BackGround Start

	@And("I click on {string} in top menu")
	public void clickCreate(String globalOption) throws InterruptedException {
		topMenu.clickCreate(globalOption);
	}

	@And("click on {string}")
	public void clickClient(String menuClientOption) throws InterruptedException {
		topMenu.clickClient(menuClientOption);
	}

	// BackGround End

	@When("go to {string} page")
	public void i_go_to_create_client_page(String pagename) {

	}

	@And("enter client details")
	public void enter_client_details(List<ClientData> clientData) throws InterruptedException, AWTException {
		// context.log("enter and submit client details " + clientData.size());
		// context.log("enter and submit client details " +
		// clientData.get(0).firstName);
		createClientPage.submitClientDetails(clientData);
	}

	@DataTableType
	public ClientData entry(Map<String, String> entry) {
		return new ClientData(entry.get("FirstName"), entry.get("LastName"));
	}

	@Then("click on Cancel button")
	public void cancel_button_click() {

	}

}
