package com.hbm.ui.teststeps;

import com.aventstack.extentreports.ExtentReports;
import com.hbm.ui.context.TestContext;
import com.hbm.ui.pages.CreateGroupPage;
import com.hbm.ui.pages.LoginPage;
import com.hbm.ui.pages.TopMenuComponent;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateGroup {
	WebDriver driver;
	public TestContext context;
	public CreateGroupPage createGroupPage;
	public LoginPage loginPage;
//	static ExtentReports reports;
	public TopMenuComponent topMenu;

	public CreateGroup(TestContext context) {
		this.context = context;
		this.createGroupPage = context.getPageObjectManager().getCreateGroupPage();
		this.loginPage = context.getPageObjectManager().getLoginPage();
		this.topMenu = context.getPageObjectManager().getTopMenu();
	}

	// BackGround Start

	@And("click on {string} in top menu")
	public void clickCreate(String globalOption) throws InterruptedException {
		topMenu.clickCreate(globalOption);
	}

	@And("I click on {string}")
	public void clickGroup(String menuGroupOption) throws InterruptedException {
		topMenu.clickGroup(menuGroupOption);
	}

	// BackGround End

	@Given("I am logged into Mambu")
	public void i_am_logged_into_mambu() throws InterruptedException {
		loginPage.doLogin();
	}

	@When("go to create group page")
	public void create_group_page() {

	}

	@And("enter group name")
	public void enter_group_name() throws InterruptedException {
		createGroupPage.submitGroupDetails();

	}

	@Then("click on the Cancel button")
	public void click_cancel_button() {

	}

}
