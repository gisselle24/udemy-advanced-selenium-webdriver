package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage extends BasePageObject {

	private By checkbox = By.xpath("//input[@type='checkbox']");

	public CheckBoxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}	

	/**
	 * Get list of all check boxes and check if unchecked
	 */
	public void selectAllCheckBoxes() {
		log.info("Check all uncheked checkboxes");
		List<WebElement> checkBoxes = findAll(checkbox);
		for (WebElement checkbox : checkBoxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
	
	/**
	 * UnCheck all check boxes
	 */
	public void unCheckAllCheckBoxes() {
		log.info("UnCheck all checkboxes");
		List<WebElement> checkBoxes = findAll(checkbox);
		for (WebElement checkbox : checkBoxes) {
			if (checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	/**
	 * Verify all available check boxes are checked. If at list one unchecked,
	 * return false
	 */
	public boolean areAllCheckBoxesChecked() {
		log.info("Verifying all checkboxes are checked");
		List<WebElement> checkBoxes = findAll(checkbox);
		for (WebElement checkbox : checkBoxes) {
			if (!checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Verify all available check boxes are UnChecked. If at list one checked,
	 * return false
	 */
	public boolean areAllCheckBoxesUnChecked() {
		log.info("Verifying all checkboxes are checked");
		List<WebElement> checkBoxes = findAll(checkbox);
		for (WebElement checkbox : checkBoxes) {
			if (checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}

}
