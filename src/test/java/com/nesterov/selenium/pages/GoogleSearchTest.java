package com.nesterov.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.nesterov.selenium.configuration.GoogleSearchConfig;

@SpringJUnitConfig(GoogleSearchConfig.class)
@ExtendWith(SpringExtension.class)
class GoogleSearchTest {
	
	@Autowired
	protected WebDriver driver;
	@Autowired
	private GoogleSearch search;

	@BeforeEach
	void setUp() {
		driver.get(search.getUrl());
		search = PageFactory.initElements(driver, GoogleSearch.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	void givenGooglSearchScenario_whenExecuteScenario_thenExpectedPageTitleReturned() {
		String keyWord = "selenium install ubuntu python";
		search.sendKeysToFormInputSearch(keyWord);
		search.clickButton();
		search.clickLinkPyPI();
		search.sendKeysToSearchProjectInput("selenium");
		search.clickSearchProject();
		search.clickSeleniumAmazonlink();
		String expected = "amazon-selenium · PyPI";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
}
