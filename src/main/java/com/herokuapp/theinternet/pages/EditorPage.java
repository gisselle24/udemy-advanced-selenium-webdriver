package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject {

	private By texteditorLocator = By.id("tinymce");
	private By frame = By.id("mce_0_ifr");

	public EditorPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public String getEditorText() {
		switchToFrame(frame);
		String text = find(texteditorLocator).getText();
		log.info("Text from WYSIWYG Editor: " + text);
		return text;
	}

}
