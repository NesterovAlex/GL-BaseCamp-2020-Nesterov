package com.nesterov.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

class GLCareersResultPageTest {

	private WebDriver driver;
	private GLCareersResultPage careersPage;

	@BeforeEach
	void setUp() throws Exception {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		careersPage = new GLCareersResultPage(driver);
		careersPage = PageFactory.initElements(driver, GLCareersResultPage.class);
	}

	@Test
	void givenExpectedUrl_whenOpen_thenReturnedCurrentUrl() {
		String expected = "https://www.globallogic.com/ua/career-search-page/?keywords=QA&experience=&locations=&c=";
		careersPage.open("QA");
		careersPage.getFirstResult();
		assertEquals(expected, driver.getCurrentUrl());
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

}
