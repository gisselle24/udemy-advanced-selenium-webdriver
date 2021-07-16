package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadingFilesPage extends BasePageObject {

	private By selectFileLocator = By.id("file-upload");
	private By uploadLocator = By.id("file-submit");
	private By uploadedFileLocator = By.id("uploaded-files");

	public UploadingFilesPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Push upload button
	 */
	public void pushUploadButton() {
		log.info("Clicking on upload button");
		find(uploadLocator).click();
	}

	/**
	 * Select file from given path
	 */
	public void selectFile(String fileName) {
		log.info("Selecting file '" + fileName + " ' from files folder");
		// Selecting file
		// String
		// filePath="D:\\Selenium\\Elipse\\Projects\\Udemy\\udemy-advanced-selenium-webdriver\\src\\main\\resources\\files\\foto.jpeg";
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, selectFileLocator);
		log.info("File Selected");
	}

	/**
	 * Get name of uploaded files
	 */
	public String getUploadedFilesNames() {
		String names = find(uploadedFileLocator).getText();
		log.info("Uploaded files: " + names);
		return names;

	}
}
