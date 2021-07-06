package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	private String pageURL = "http://the-internet.herokuapp.com/secure";

	private By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
	private By messageLocator = By.id("flash");

	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/**
	 * Get URL variable from PageObject
	 */
	public String getPageUrl() {
		return pageURL;
	}

	/**
	 * Verification if logOut button is visible on the page
	 */
	public boolean isLogOutButtonVisible() {
		return find(logOutButtonLocator).isDisplayed();
	}

	/**
	 * Return text from success message
	 */
	public String getSuccessMessageText() {
		return find(messageLocator).getText();

	}

}
