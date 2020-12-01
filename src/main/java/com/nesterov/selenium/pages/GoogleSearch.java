package com.nesterov.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleSearch {

	@Value(value = "${url}")
	public String url;
	
	@FindBy(xpath = "//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement formInputSearch;
	                  
	@FindBy(xpath = "//body/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]/div[1]/div[3]/center[1]/input[1]")
	private WebElement googleSearchButton;
	
	@FindBy(xpath = "//span[contains(text(),'pip install selenium - PyPI')]")
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
	
	public String getUrl() {
		return url;
	}
}
