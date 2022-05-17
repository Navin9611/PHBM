
/**
 * ALL STEP DEFENTIONS WILL BE PLACED HERE
 * 
 */
package com.hbm.ui.teststeps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.hbm.ui.context.TestContext;
import com.hbm.ui.pages.LoginPage;

public class Login {

	public TestContext context;
	public LoginPage loginPage;

	public Login(TestContext context) {
		this.context = context;
		this.loginPage = this.context.getPageObjectManager().getLoginPage();

	}

	@Given("User navigates to mambu application")
	public void user_navigates_to_mambu_application() throws InterruptedException {
		loginPage.doLogin();
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
	}

	@When("click on the submit button")
	public void click_on_the_submit_button() {

	}

	@Then("login must be successful")
	public void login_must_be_successful() throws InterruptedException {
		
	}

}
