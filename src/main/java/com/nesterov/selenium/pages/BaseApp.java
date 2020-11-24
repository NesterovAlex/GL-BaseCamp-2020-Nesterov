package com.nesterov.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class BaseApp {

	private WebDriver browser;
	private WebDriverWait webDriverWait;

	public BaseApp() {
	}

	public BaseApp(WebDriver browser, WebDriverWait webDriverWait) {
		this.browser = browser;
		this.webDriverWait = webDriverWait;

	}

	public WebDriver getBrowser() {
		return browser;
	}

	public void setBrowser(WebDriver browser) {
		this.browser = browser;
	}

	public WebDriverWait getWebDriverWait() {
		return webDriverWait;
	}

	public void setWebDriverWait(WebDriverWait webDriverWait) {
		this.webDriverWait = webDriverWait;
	}

	public void open(String url) {
		browser.get(url);
	}

	public void click(By by) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void sendKey(By by, String key) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(key);
	}

	public WebElement find(By by) {
		return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void quit() {
		browser.quit();
	}
}
