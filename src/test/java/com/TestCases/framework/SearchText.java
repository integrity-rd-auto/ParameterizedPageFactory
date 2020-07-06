package com.TestCases.framework;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Base.framework.MultiBrowser;
import com.Pages.framework.HomePage;

public class SearchText extends MultiBrowser {
	HomePage homepage;

	@BeforeTest

	public void setup() {

		homepage = new HomePage(driver);

	}

	@Test
	public void login() throws InterruptedException {

		homepage.insertSearchText();		
		Assert.assertEquals(driver.getTitle(), "Selenium - Google Search");
			}

}
