package com.nesterov.selenium.pages;

import static com.nesterov.config.PageConfig.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class GLCareersResultPage extends BaseApp {
	
	private static final By FIRST_RESULT_ELEMENT = By.xpath("//body/div[@id='main']/section[@id='carersearchpage']/div[2]/div[1]/div[3]/div[2]/a[1]/div[1]/div[1]");

	public GLCareersResultPage(WebDriver browser, WebDriverWait webDriverWait) {
		super(browser, webDriverWait);
	}

	@Override
	public void open(String vacancy) {
		StringBuilder builder = new StringBuilder();
		builder.append(FIRST_PART_URL + vacancy
				+ SECOND_PART_URL);
		super.open(builder.toString());
	}

	public void getFirstResult() {
		System.out.println(find(FIRST_RESULT_ELEMENT).getText());
	}

	public WebDriver getDriver() {
		return getBrowser();
	}
}
