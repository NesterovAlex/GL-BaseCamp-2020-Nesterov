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

class GlobalLogicCareersPageTest {

	protected WebDriver driver;
	private GlobalLogicCareersPage careersPage;

	@BeforeEach
	void setUp() throws Exception {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(GlobalLogicCareersPage.URL);
		careersPage = PageFactory.initElements(driver, GlobalLogicCareersPage.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		careersPage.clickallowCoockysButton();
	}

	@Test
	void givenHomePage_whenExecuteScenario_thenCurrentUrlReturned() {
		careersPage.sendKeysToFormInputSearch("QA");
		careersPage.clickSearchButton();
		careersPage.printFirstResult();
		assertEquals("https://www.globallogic.com/ua/career-search-page/?keywords=QA&experience=&locations=&c=",
				driver.getCurrentUrl());
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
}
