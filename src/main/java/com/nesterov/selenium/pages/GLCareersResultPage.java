package com.nesterov.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GLCareersResultPage extends BaseApp {

	private static final By FIRST_RESULT_ELEMENT = By.xpath(
			"//body/div[@id='main']/section[@id='carersearchpage']/div[2]/div[1]/div[3]/div[2]/a[1]/div[1]/div[1]");

	private WebDriver browser = super.browser;

	public GLCareersResultPage(WebDriver browser) {
		super(browser);
		driverWait = new WebDriverWait(browser, Duration.ofSeconds(40));
	}

	public void open(String vacancy) {
		StringBuilder builder = new StringBuilder();
		builder.append("https://www.globallogic.com/ua/career-search-page/?keywords=" + vacancy
				+ "&experience=&locations=&c=");
		browser.get(builder.toString());
	}

	public void getFirstResult() {
		System.out.println(find(FIRST_RESULT_ELEMENT).getText());
	}

}
