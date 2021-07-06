package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptsAlertsPage extends BasePageObject {

	private By jSAlertLocator = By.xpath("//button[.='Click for JS Alert']");
	private By jSConfirmLocator = By.xpath("//button[.='Click for JS Confirm']");
	private By jSPromptLocator = By.xpath("//button[.='Click for JS Prompt']");
	private By resultLocator = By.id("result");

	public JavaScriptsAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open JSAlert by clicking JSAlert button */
	public void clickJSAlert() {
		log.info("Clicking JSAlert button");
		click(jSAlertLocator);
	}
	
	/** Open JSConfirm by clicking JSConfirm button */
	public void clickJSConfirm() {
		log.info("Clicking JSConfirm button");
		click(jSConfirmLocator);
	}
	
	/** Open JSPrompt by clicking JSPrompt button */
	public void clickJSPrompt() {
		log.info("Clicking JSPrompt button");
		click(jSPromptLocator);
	}

	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert says: " + alertText);
		return alertText;
	}

	public void acceptAlert() {
		Alert alert = switchToAlert();
		alert.accept();
		log.info("JSAlert accepted");
	}
	
	public void dismissAlert() {
		Alert alert = switchToAlert();
		alert.dismiss();
		log.info("JSAlert dismissed");
	}
	
	public void sendKeysToAlert(String text) {
		Alert alert = switchToAlert();
		alert.sendKeys(text);
		log.info("JSAlert wrote text succefully");
	}

	public String getResultText() {
		String resultText = find(resultLocator).getText();
		log.info("Result says: " + resultText);
		return resultText;
	}

}
