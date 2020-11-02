package com.nesterov.selenium.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.*;

public class GlobalLogicCareersPage {

	public static final String URL = "https://www.globallogic.com/ua/careers/";

	private WebDriver driver;

	public GlobalLogicCareersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeysToFormInputSearch(String keysToSend) {
		WebElement searchInputFieldElement = new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//body/div[@id='main']/section[@id='hero']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")));
		searchInputFieldElement.sendKeys(keysToSend);
	}

	public void clickallowCoockysButton() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40));
		WebElement allowCoockies = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"));
			}
		});
		allowCoockies.click();
	}

	public void clickSearchButton() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50));
		WebElement searchButton = wait.until(new java.util.function.Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(
						"//body/div[@id='main']/section[@id='hero']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]"));
			}
		});
		searchButton.click();
	}

	public void printFirstResult() {
		WebElement firstResultElement = new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//body/div[@id='main']/section[@id='carersearchpage']/div[2]/div[1]/div[3]/div[2]/a[1]/div[1]/div[1]")));
		System.out.println(firstResultElement.getText());
	}

}
