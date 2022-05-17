package com.hbm.ui.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {

	WebDriver driver;
	ExtentTest test;
	Properties prop;
	SoftAssert softAssert;

	public WebDriverUtil() throws FileNotFoundException {

		/**
		 * Initializing the properties files It loads all the properties from
		 * ui.properties file
		 */

		try {

			prop = new Properties();
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\ui.properties\\";
			List<String> fileList = new ArrayList<>();
			getAllFiles(path, fileList);
			for (String individualfile : fileList) {
				String filesPaths = path + individualfile;
				FileInputStream fs = new FileInputStream(filesPaths);
				prop.load(fs);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		softAssert = new SoftAssert();
	}

	private static void getAllFiles(String path, List<String> fileList) {
		File[] allFiles = new File(path).listFiles();

		if (allFiles != null) {
			for (File file : allFiles) {
				if (file.isFile() && file.getName().endsWith(".properties")) {
					fileList.add(file.getName());
				} else if (file.isDirectory()) {
					getAllFiles(file.getAbsolutePath(), fileList);
				}
			}
		}
	}

	/**
	 * Downloading the drivers based on the Operating System & Launching the Browser
	 * based on the Browser name provided in the config.properties File
	 */
	public void openBrowser(String browser) {

		log("Open browser " + browser.toLowerCase().substring(0, 1).toUpperCase() + browser.substring(1).toLowerCase());
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("Chrome")) {
				/*
				 * WebDriverManager.chromedriver().driverVersion("85.0.4183.83").setup();
				 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				 * + "\\src\\test\\resources\\ui.drivers\\chromedriver.exe");
				 */
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				browserVersion();
			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				browserVersion();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (System.getProperty("os.name").contains("Linux")) {

			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				browserVersion();
			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				browserVersion();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (System.getProperty("os.name").contains("Mac")) {

			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				browserVersion();
			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				browserVersion();
			} else if (browser.equalsIgnoreCase("Safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				browserVersion();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
	}

	public void navigate(String urlKey) {
		log("Navigating to " + getProperty(urlKey));
		driver.get(getProperty(urlKey));
	}

	public void click(String locatorKey) {
		log("Clicking on " + locatorKey.substring(0, locatorKey.lastIndexOf("_")).replace(".", " ").toUpperCase());
		findElement(locatorKey).click();

	}

	public void type(String locatorKey, String data) {
		log("Typing in " + locatorKey.substring(0, locatorKey.lastIndexOf("_")).replace(".", " ").toUpperCase());
		findElement(locatorKey).sendKeys(data);
	}

	public WebElement findElement(String locatorKey) {
		By locator = getLocator(locatorKey);
		WebElement e = null;
		try {
			// present and visible
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			e = driver.findElement(locator);
		} catch (Exception ex) {
			// report failure
			logFailure("Object not found " + locatorKey, true);

		}
		return e;
	}

	/**
	 * Identifying the Objects Based in the its type Eg: xp = XPath, id=id,
	 * name=Name
	 */
	public By getLocator(String locatorKey) {

		if (locatorKey.endsWith("_id"))
			return By.id(getProperty(locatorKey));
		else if (locatorKey.endsWith("_name"))
			return By.name(getProperty(locatorKey));
		else if (locatorKey.endsWith("_xp"))
			return By.xpath(getProperty(locatorKey));
		else
			return By.cssSelector(getProperty(locatorKey));

	}

	/**
	 ************************** Validation Functions **************************
	 */

	/**
	 * Verify the title of the page
	 */
	public boolean verifyTitle(String expectedTitleKey) {
		String expectedTitle = getProperty(expectedTitleKey);
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle))
			return true;
		else
			return false;
	}

	/**
	 * Presence and Visibility of the Element
	 */

	public boolean isElementPresent(String locatorKey) {
		By locator = getLocator(locatorKey);

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/**
	 ************************** Utility Functions **************************
	 */

	public void init(ExtentTest test) {
		this.test = test;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}

	public void logFailure(String msg, boolean stopExecution) {
		System.out.println("FAILURE:  " + msg);
		// fail in extent reports
		test.log(Status.FAIL, msg);
		// fail in testng-cucumber
		softAssert.fail(msg);
		if (stopExecution)
			softAssert.assertAll();
	}

	public void quit() {
		if (driver != null)
			driver.quit();
		// if (softAssert != null)
		// softAssert.assertAll();

	}

	public void browserVersion() {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserVersion = caps.getVersion();
		log("Browser Version is : " + browserVersion);
	}

}
