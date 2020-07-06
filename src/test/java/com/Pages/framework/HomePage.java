package com.Pages.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

@FindBy(xpath="//input[@name='q']")
	
	WebElement searchBox;
	
	
	public void insertSearchText() throws InterruptedException {
		
		searchBox.sendKeys("Selenium");
        
		searchBox.submit();
		Thread.sleep(300);
	}

}
