package com.hbm.ui.teststeps;

import com.hbm.ui.context.TestContext;
import com.hbm.ui.pages.ClientSearchPage;
import com.hbm.ui.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientSearch {
	
	public TestContext context;
	public ClientSearchPage clientSearchPage;
	public LoginPage loginPage;
	
	public ClientSearch(TestContext context) {
		this.context = context;		
		this.clientSearchPage=context.getPageObjectManager().getClientSearchPage();
		this.loginPage = context.getPageObjectManager().getLoginPage();		
	}
	
	@Given("logged into Mambu")
	public void i_am_logged_in_mambu() throws InterruptedException {		
		loginPage.doLogin();
		Thread.sleep(5000);
	}

    @When("Go to mambu landing page")
    public void go_to_mambu_launching_page() throws Throwable {
    	clientSearchPage.submitClientDetailsSearch();
    }

    @And("Enter existing client name")
    public void enter_existing_client_name() throws Throwable {
    }

    @Then("Navigate to Client details Page")
    public void navigate_to_client_details_page() throws Throwable {
    }

}
