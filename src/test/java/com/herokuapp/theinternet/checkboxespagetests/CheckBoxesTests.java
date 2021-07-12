package com.herokuapp.theinternet.checkboxespagetests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckBoxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckBoxesTests extends TestUtilities {

	@Test(priority = 1)
	public void selectingTwoCheckboxesTest() {
		log.info("Starting selectingTwoCheckboxesTest");

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on check boxes link
		CheckBoxesPage checkbox = welcomePage.clickCheckBoxesLink();

		// Select all check boxes
		checkbox.selectAllCheckBoxes();

		// Verify all check boxes are checked
		assertTrue(checkbox.areAllCheckBoxesChecked(),"Not all check boxes are checked");
		
	}
	
	@Test(priority = 2)
	public void selectAndDeselectOneCheckBoxTest() {
		log.info("Starting selectingTwoCheckboxesTest");

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on check boxes link
		CheckBoxesPage checkbox = welcomePage.clickCheckBoxesLink();

		// Select all check boxes
		checkbox.selectAllCheckBoxes();

		// Verify all check boxes are checked
		assertTrue(checkbox.areAllCheckBoxesChecked(),"Not all check boxes are checked");
		
		//UnCheck all check boxes
		checkbox.unCheckAllCheckBoxes();
		
		//Verify all check boxes are unchecked
		assertTrue(checkbox.areAllCheckBoxesUnChecked(), "Some check boxes are still selected");
		
	}


}
