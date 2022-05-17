package com.hbm.ui.context;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hbm.ui.reports.ExtentManager;
import com.hbm.ui.utilities.PageObjectManager;

public class TestContext {

	ExtentReports report;
	ExtentTest test;

	private PageObjectManager pageObjectManager;

	public TestContext() throws IOException {
		// initialize the reports
		report = ExtentManager.getReports();
		this.pageObjectManager = new PageObjectManager();

	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void createScenario(String scenarioName) {
		test = report.createTest(scenarioName);
		this.pageObjectManager.getWebDriverUtil().init(test);
		
	}

	public void endScenario() {
		this.pageObjectManager.getWebDriverUtil().quit();
		report.flush();

	}

	public void log(String msg) {
		this.pageObjectManager.getWebDriverUtil().log(msg);

	}

}
