package com.Base.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {

	public static WebDriver driver;
	
	public String url = "http://google.com/";

	@BeforeTest
	@Parameters("browser")

	public void MultiBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C://Driver/geckodriver.exe");
			driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
			driver.get(url);

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C://Driver/chromedriver.exe");
			driver = new ChromeDriver(OptionsManager.getChromeOptions());
			driver.get(url);

		}

	}
	
	@AfterClass
	
	public void terminate() {
		
		driver.quit();
	}
	
}