package com.nesterov.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

class GoogleSearchTest {

	protected WebDriver driver;
	private GoogleSearch search;

	@BeforeEach
	void setUp() throws Exception {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(GoogleSearch.URL);
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
	void tearDown() throws Exception {
		driver.quit();
	}

}
