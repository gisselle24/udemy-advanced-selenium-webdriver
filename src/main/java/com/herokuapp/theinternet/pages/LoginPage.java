package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By logInButtonLocator = By.tagName("button");
	private By messageLocator = By.id("flash");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/* Execute log in */
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
		return new SecureAreaPage(driver, log);
	}

	/* Execute log in */
	public void negativeLogIn(String username, String password) {
		log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
	}

	public void waitForErrorMessage() {
		waitForVisibilityOf(messageLocator, 5);
	}

	public String getErrorMessage() {
		return find(messageLocator).getText();

	}

}
