package com.nesterov.selenium.pages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.nesterov.selenium.configuration.GLCareersResultPageConfig;

@SpringJUnitConfig(GLCareersResultPageConfig.class)
@ExtendWith(SpringExtension.class)
class GLCareersResultPageTest {

	private GLCareersResultPage glCareersResultPage;

	@Autowired
	public void setGLCareersPage(GLCareersResultPage glCareersResultPage) {
		this.glCareersResultPage = glCareersResultPage;
	}

	@Test
	void givenExpectedUrl_whenOpen_thenReturnedCurrentUrl() {
		String expected = "https://www.globallogic.com/ua/career-search-page/?keywords=QA&experience=&locations=&c=";
		glCareersResultPage.open("QA");
		glCareersResultPage.getFirstResult();
		assertEquals(expected, glCareersResultPage.getDriver().getCurrentUrl());
	}

	@AfterEach
	void tearDown() {
		glCareersResultPage.getDriver().quit();
	}
}
