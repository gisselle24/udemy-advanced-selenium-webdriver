package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {
	private By body = By.xpath("//body");
	private By resultText = By.id("result");

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Press given key on the page
	 */
	public void pushKeyboardKey(Keys key) {
		log.info("Pressing: " + key.name());
		pressKey(body, key);
	}

	/**
	 * Get result text from the "Key Presses" page
	 */
	public String getResultText() {
		String result = find(resultText).getText();
		log.info("Messeage result is: " + result);
		return result;

	}

}
