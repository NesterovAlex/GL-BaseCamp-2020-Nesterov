package com.nesterov.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GLCareersPage extends BaseApp {

	private static final String URL = "https://www.globallogic.com/ua/careers/";

	private static final By SEARCH_FIELD = By.xpath(
			"//body/div[@id='main']/section[@id='hero']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
	private static final By SEARCH_BUTTON = By.xpath(
			"//body/div[@id='main']/section[@id='hero']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]");
	private static final By ALLOW_COOKIE_BUTTON = By
			.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
	private static final By FIRST_RESULT_ELEMENT = By.xpath(
			"//body/div[@id='main']/section[@id='carersearchpage']/div[2]/div[1]/div[3]/div[2]/a[1]/div[1]/div[1]");

	private WebDriver browser = super.browser;

	public GLCareersPage(WebDriver browser) {
		super(browser);
		driverWait = new WebDriverWait(browser, Duration.ofSeconds(40));
	}

	public void open() {
		browser.get(GLCareersPage.URL);
		clickallowCoockysButton();
	}

	public WebDriver getBrowser() {
		return browser;
	}

	public void setBrowser(WebDriver browser) {
		this.browser = browser;
	}

	public void searchVacancy(String vacancy) {
		sendKey(SEARCH_FIELD, vacancy);
	}

	public void clickallowCoockysButton() {
		click(ALLOW_COOKIE_BUTTON);
	}

	public void clickSearchButton() {
		click(SEARCH_BUTTON);
	}

	public void printFirstResult() {
		System.out.println(find(FIRST_RESULT_ELEMENT).getText());
	}

}
