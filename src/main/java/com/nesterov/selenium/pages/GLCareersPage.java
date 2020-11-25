package com.nesterov.selenium.pages;

import static com.nesterov.selenium.configuration.PageConfig.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class GLCareersPage extends BaseApp {

	private static final By SEARCHFIELD = By.xpath("//body/div[@id='main']/section[@id='hero']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
	private static final By SEARCH_BUTTON = By.xpath("//body/div[@id='main']/section[@id='hero']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]");
	private static final By ALLOW_COOKIE_BUTTON = By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
	private static final By FIRST_RESULT_ELEMENT = By.xpath("//body/div[@id='main']/section[@id='carersearchpage']/div[2]/div[1]/div[3]/div[2]/a[1]/div[1]/div[1]");

	public GLCareersPage(WebDriver browser, WebDriverWait webDriverWait) {
		super(browser, webDriverWait);
	}

	public void open() {
		open(GL_CAREERS_PAGE);
		clickallowCoockysButton();
	}

	public void searchVacancy(String vacancy) {
		sendKey(SEARCHFIELD, vacancy);
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
	
	public WebDriver getDriver() {
		return getBrowser();
	}
}
