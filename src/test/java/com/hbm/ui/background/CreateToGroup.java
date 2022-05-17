package com.hbm.ui.background;

import com.hbm.ui.context.TestContext;
import com.hbm.ui.pages.TopMenuComponent;

import io.cucumber.java.en.And;

public class CreateToGroup {
    public TestContext context;
    public TopMenuComponent topMenu;
    
    
	public CreateToGroup(TestContext context) {
		this.context=context;
		this.topMenu=context.getPageObjectManager().getTopMenu();
	}
	
	
	@And("click on {string} in top menu")
	public void clickCreate(String globalOption) throws InterruptedException {
		//context.log("Click on "+globalOption.toUpperCase()+" in top menu");
		topMenu.clickCreate(globalOption);
	}
	
	@And("I click on {string}")
	public void clickGroup(String menuOption2) throws InterruptedException {
		//context.log("Click on "+ menuOption2.toUpperCase()+" Option");
		topMenu.clickGroup(menuOption2);
		Thread.sleep(3000);
	} 

}
