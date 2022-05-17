package com.hbm.ui.utilities;

import java.io.FileNotFoundException;

import com.hbm.ui.pages.ClientSearchPage;
import com.hbm.ui.pages.CreateClientPage;
import com.hbm.ui.pages.CreateGroupPage;
import com.hbm.ui.pages.LoginPage;
import com.hbm.ui.pages.MakeDepositPage;
import com.hbm.ui.pages.TopMenuComponent;

public class PageObjectManager {

	LoginPage loginPage;
	TopMenuComponent topMenu;
	CreateClientPage createClientPage;
	CreateGroupPage createGroupPage;
	ClientSearchPage clientSearchPage;
	MakeDepositPage makeDepositPage;
	WebDriverUtil app;

	public PageObjectManager() {
	
			try {
				this.app = new WebDriverUtil();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	} 
	

	public WebDriverUtil getWebDriverUtil() {
		return app;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(app);
		return loginPage;
	}

	public TopMenuComponent getTopMenu() {
		if (topMenu == null)
			topMenu = new TopMenuComponent(app);
		return topMenu;
	}

	public CreateClientPage getCreateClientPage() {
		if (createClientPage == null)
			createClientPage = new CreateClientPage(app);
		return createClientPage;
	}

	public CreateGroupPage getCreateGroupPage() {
		if (createGroupPage == null)
			createGroupPage = new CreateGroupPage(app);
		return createGroupPage;
	}
		
		public ClientSearchPage getClientSearchPage() {
			if (clientSearchPage == null)
				clientSearchPage = new ClientSearchPage(app);
			return clientSearchPage;		
	}
		
		public MakeDepositPage getMakeDepositPage() {
			if (makeDepositPage == null)
				makeDepositPage = new MakeDepositPage(app);
			return makeDepositPage;		
	}
		
		
}
