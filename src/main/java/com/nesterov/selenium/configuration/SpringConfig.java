package com.nesterov.selenium.configuration;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nesterov.selenium")
@PropertySource(value = "classpath:gl_careers_page.properties", encoding="UTF-8")
public class SpringConfig {

	@Bean
	public WebDriver webDriver() {
		return new ChromeDriver();
	}
	
	@Bean
	public WebDriverWait webDriverWait(WebDriver webDriver) {
		return new WebDriverWait(webDriver, Duration.ofSeconds(40));
	}
}
