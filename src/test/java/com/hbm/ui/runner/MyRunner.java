package com.hbm.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/resources/ui.features", tags ="@Smoke", glue = { "com.hbm.ui.teststeps" }, plugin = {
				"html:target/cucumber-reports.html"})



public class MyRunner extends AbstractTestNGCucumberTests {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
