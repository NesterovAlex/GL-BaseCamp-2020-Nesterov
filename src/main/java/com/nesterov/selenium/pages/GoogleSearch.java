package com.nesterov.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch {

	public static final String URL = "https://www.google.com.ua/";
	
	@FindBy(xpath = "//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement formInputSearch;
	                  
	@FindBy(xpath = "//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[2]/div[2]/div[2]/center[1]/input[1]")
	private WebElement googleSearchButton;
	
	@FindBy(xpath = "//span[contains(text(),'selenium · PyPI')]")
	private WebElement pyPILink;
	
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchProjectInputField;
	
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/form[1]/button[1]/i[1]")
	private WebElement searchProjectButton;
	
	@FindBy(xpath = "//span[contains(text(),'amazon-selenium')]")
	private WebElement seleniumAmazonLink;
	
	public void sendKeysToFormInputSearch(String keysToSend) {
		formInputSearch.sendKeys(keysToSend);
	}
	
	public void clickButton() {
		googleSearchButton.click();
	}
	
	public void clickLinkPyPI() {
		pyPILink.click();
	}
	
	public void sendKeysToSearchProjectInput(String keysToSend) {
		searchProjectInputField.sendKeys(keysToSend);
	}
	
	public void clickSearchProject() {
		searchProjectButton.click();
	}
	
	public void clickSeleniumAmazonlink() {
		 seleniumAmazonLink.click();
	}
	
}
