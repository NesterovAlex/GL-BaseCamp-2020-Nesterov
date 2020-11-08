package com.nesterov.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

class GLCareersPageTest {

	protected WebDriver driver;
	private GLCareersPage careersPage;

	@BeforeEach
	void setUp() throws Exception {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		careersPage = new GLCareersPage(driver);
		careersPage.open();
		careersPage = PageFactory.initElements(driver, GLCareersPage.class);
	}

	@Test
	void givenHomePage_whenExecuteScenario_thenCurrentUrlReturned() {
		careersPage.searchVacancy("QA");
		careersPage.clickSearchButton();
		careersPage.printFirstResult();
		assertEquals("https://www.globallogic.com/ua/career-search-page/?keywords=QA&experience=&locations=&c=",
				careersPage.getBrowser().getCurrentUrl());
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
}
