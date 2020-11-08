package com.nesterov.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseApp {

	public WebDriver browser;
	public WebDriverWait driverWait;

	public BaseApp(WebDriver browser) {
		this.browser = browser;
	}

	public void click(By by) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
	}

	public void sendKey(By by, String key) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(key);
	}
	
	public WebElement find(By by) {
		return driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
