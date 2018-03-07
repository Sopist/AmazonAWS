package com.amazonaws.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * WebDriver factory
 * Takes string as input and returns the implementation of the webdriver based on that
 */

public class Driver {

	private static WebDriver driver;
	
	public static WebDriver getDriver(String browser) {
		
		String driverType = browser == null ? Configuration.getProperty("browser") : browser;
		// if browser has value, use browser
		// else use the value from the configuration file
		
		if(driver == null) {
						
			// Create webdriver based on the value of browser parameter
			switch (driverType.toLowerCase()) {
			case "chrome":
				System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_PATH);
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty(Constants.FIREFOX_DRIVER, Constants.FIREFOX_PATH);
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty(Constants.IE_DRIVER, Constants.IE_PATH);
				driver = new InternetExplorerDriver();
				break;
			case "safari":
				break;
			case "edge":
				break;
			}
		}
		
		// return that webdriver value
		return driver;
	}
	
	// Killing object completely
	public static void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
