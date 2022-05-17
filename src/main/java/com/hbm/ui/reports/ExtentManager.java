package com.hbm.ui.reports;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hbm.ui.utilities.WebDriverUtil;

public class ExtentManager {
	static ExtentReports reports;
	public static String screenshotFolderPath;

	public static ExtentReports getReports() throws IOException {
		//WebDriverUtil app = new WebDriverUtil();
		if (reports == null) {
			reports = new ExtentReports();
			Date d = new Date();

			String reportsFolder = d.toString().replaceAll(":", "-") + "//screenshots";
			screenshotFolderPath = System.getProperty("user.dir") + "//hbm.ui.automation.reports//" + reportsFolder;
			String reportFolderPath = System.getProperty("user.dir") + "//hbm.ui.automation.reports//"
					+ d.toString().replaceAll(":", "-");
			File f = new File(screenshotFolderPath);
			f.mkdirs();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath);

			sparkReporter.config().setReportName("HBM Regression Testing");
			sparkReporter.config().setDocumentTitle("HBM Automation Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");

			reports.setSystemInfo("User Name", System.getProperty("user.name"));
			reports.setSystemInfo("Operating System", System.getProperty("os.name"));
			reports.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
			//reports.setSystemInfo("Brower", app.getProperty("Browser").toLowerCase());
			reports.attachReporter(sparkReporter);
		}

		return reports;

	}

}
