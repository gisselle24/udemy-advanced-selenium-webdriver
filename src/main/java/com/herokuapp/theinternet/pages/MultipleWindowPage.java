package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowPage extends BasePageObject {
	private By clickHereLocator = By.xpath("//a[@href='/windows/new']");

	public MultipleWindowPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public NewWindow openNewWindow() {
		log.info("Clicking 'Click here' link");
		find(clickHereLocator).click();
		return new NewWindow(driver, log);
	}

	public NewWindow switchToNewWindowPage() {
		log.info("Looking for 'New window' page");
		switchToNewWindowWithTitle("New Window");
		return new NewWindow(driver, log);
	}

}
