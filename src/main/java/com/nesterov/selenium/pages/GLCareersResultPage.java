package com.nesterov.selenium.pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class GLCareersResultPage extends BaseApp {
	
	private static final Properties PROPERTIES = ResourceReader.readFile("gl_careers_result_page.properties");
	private static final By FIRST_RESULT_ELEMENT = By.xpath(PROPERTIES.getProperty("FIRST_RESULT_ELEMENT_PATH"));

	public GLCareersResultPage(WebDriver browser, WebDriverWait webDriverWait) {
		super(browser, webDriverWait);
	}

	@Override
	public void open(String vacancy) {
		StringBuilder builder = new StringBuilder();
		builder.append("https://www.globallogic.com/ua/career-search-page/?keywords=" + vacancy
				+ "&experience=&locations=&c=");
		super.open(builder.toString());
	}

	public void getFirstResult() {
		System.out.println(find(FIRST_RESULT_ELEMENT).getText());
	}

	public WebDriver getDriver() {
		return getBrowser();
	}
}
