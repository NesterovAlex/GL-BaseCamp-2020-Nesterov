package com.nesterov.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.nesterov.selenium.configuration.GLCareersPageConfig;

@SpringJUnitConfig(GLCareersPageConfig.class)
@ExtendWith(SpringExtension.class)
class GLCareersPageTest {

	private static GLCareersPage glCareersPage;

	@Autowired
	public void setGLCareersPage(GLCareersPage careersPage) {
		GLCareersPageTest.glCareersPage = careersPage;
	}

	@BeforeEach
	void setUp() throws Exception {
		glCareersPage.open();
	}

	@Test
	void givenHomePage_whenExecuteScenario_thenCurrentUrlReturned() {
		String expected = "https://www.globallogic.com/ua/career-search-page/?keywords=QA&experience=&locations=&c=";
		glCareersPage.searchVacancy("QA");
		glCareersPage.clickSearchButton();
		glCareersPage.printFirstResult();
		assertEquals(expected, glCareersPage.getBrowser().getCurrentUrl());
	}

	@AfterAll
	static void tearDown() throws Exception {
		glCareersPage.getDriver().quit();
	}
}
