package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageURL = "http://the-internet.herokuapp.com/";

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxesLinkLocator = By.linkText("Checkboxes");
	private By dropDownLinkLocator = By.linkText("Dropdown");
	private By javaScriptLinkLocator = By.linkText("JavaScript Alerts");
	private By javaMultipleWindowLocator = By.linkText("Multiple Windows");
	private By editorLocator = By.linkText("WYSIWYG Editor");
	private By pressesKeyLocator = By.linkText("Key Presses");
	private By uploadFileLocator = By.linkText("File Upload");

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open Welcome page with its URL */
	public void openPage() {
		log.info("Opening page: " + pageURL);
		openUrl(pageURL);
		log.info("Page opened");
	}

	/** Open LoginPage by clicking on form Authentication link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking FormAuthentication Link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	/** Open CheckBoxesPage by clicking on Check Boxes link */
	public CheckBoxesPage clickCheckBoxesLink() {
		log.info("Clicking CheckBoxes Link on Welcome Page");
		click(checkBoxesLinkLocator);
		return new CheckBoxesPage(driver, log);
	}

	/** Open DropDownPage by clicking on DropDown link */
	public DropDownPage clickDropDownLink() {
		log.info("Clicking DropDown Link on Welcome Page");
		click(dropDownLinkLocator);
		return new DropDownPage(driver, log);
	}

	/** Open MultipleWindowPage by clicking on MultipleWindow link */
	public MultipleWindowPage clickMultipleWindowLink() {
		log.info("Clicking MultipleWindow Link on Welcome Page");
		click(javaMultipleWindowLocator);
		return new MultipleWindowPage(driver, log);
	}

	/** Open JavaScriptAlertsPage by clicking on JavaScriptAlerts link */
	public JavaScriptsAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JavaScriptAlerts Link on Welcome Page");
		click(javaScriptLinkLocator);
		return new JavaScriptsAlertsPage(driver, log);
	}

	/** Open Editor Page by clicking on WYSIWYGEditor link */
	public EditorPage clickWYSIWYGEditor() {
		find(editorLocator).click();
		return new EditorPage(driver, log);
	}

	/** Open Key Presses Page by clicking on KeyPresses link */
	public KeyPressesPage clickPressesKey() {
		find(pressesKeyLocator).click();
		return new KeyPressesPage(driver, log);
	}
	
	/** Open Upload files Page by clicking on UploadFiles link */
	public UploadingFilesPage clickFileUploadLink() {
		find(uploadFileLocator).click();
		return new UploadingFilesPage(driver, log);
	}

}
