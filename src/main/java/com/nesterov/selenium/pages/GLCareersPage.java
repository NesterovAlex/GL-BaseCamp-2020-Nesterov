package com.nesterov.selenium.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class GLCareersPage extends BaseApp {

	private static final Properties PROPERTIES = ResourceReader.readFile("gl_careers_page.properties");
	private static final By SEARCHFIELD = By.xpath(PROPERTIES.getProperty("SEARCH_FIELD"));
	private static final By SEARCH_BUTTON = By.xpath(PROPERTIES.getProperty("SEARC_BUTTON_PATH"));
	private static final By ALLOW_COOKIE_BUTTON = By.xpath(PROPERTIES.getProperty("ALLOW_COOKIE_BUTTON_PATH"));
	private static final By FIRST_RESULT_ELEMENT = By.xpath(PROPERTIES.getProperty("FIRST_RESULT_ELEMENT_PATH"));

	public GLCareersPage(WebDriver browser, WebDriverWait webDriverWait) {
		super(browser, webDriverWait);
	}

	public void open() {
		open(PROPERTIES.getProperty("URL"));
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
