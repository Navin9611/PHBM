package com.hbm.ui.background;

import com.hbm.ui.context.TestContext;
import com.hbm.ui.pages.TopMenuComponent;

import io.cucumber.java.en.And;

public class CreateToClient {
    public TestContext context;
    public TopMenuComponent topMenu;
    
    
	public CreateToClient(TestContext context) {
		this.context=context;
		this.topMenu=context.getPageObjectManager().getTopMenu();
	}
	
	
	@And("I click on {string} in top menu")
	public void clickCreate(String globalOption) throws InterruptedException {
		//context.log("Click on "+globalOption.toUpperCase()+" in top menu");
		topMenu.clickCreate(globalOption);
		System.out.println("I CLICKED ON"+globalOption);
	}
	
	@And("click on {string}")
	public void clickClient(String menuOption) throws InterruptedException {
		//context.log("Click on "+menuOption.toUpperCase()+" Option");
		topMenu.clickClient(menuOption);		
	} 

}
