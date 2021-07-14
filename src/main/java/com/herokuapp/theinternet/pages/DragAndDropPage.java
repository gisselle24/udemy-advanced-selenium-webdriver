package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

	String url = "http://the-internet.herokuapp.com/drag_and_drop";

	By from = By.id("column-a");
	By to = By.id("column-b");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void openPageDragAndDrop() {
		log.info("Opening drag and drop page");
		openUrl(url);
		log.info("Drag and drop page opened");
	}

	public void dragAtoB() {
		log.info("Drag and drop is going to perform");
		perfomDradAndDrop(from, to);
		log.info("Drag and drop was performing");
	}

	public String getTextFromColumnA() {
		String textFrom = find(from).getText();
		log.info("Column A have follow text: " + textFrom);
		return textFrom;

	}

	public String getTextFromColumnB() {
		String textTo = find(to).getText();
		log.info("Column B have follow text: " + textTo);
		return textTo;
	}

}
