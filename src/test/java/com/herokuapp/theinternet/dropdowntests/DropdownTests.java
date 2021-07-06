package com.herokuapp.theinternet.dropdowntests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropDownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class DropdownTests extends TestUtilities {

	@Parameters({ "option", "expectedOption" })
	@Test
	public void optionTwoTest(int option, String expectedOption) {
		log.info("Starting optionTwoTest");

		// Open main Page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// CLick on drop down link
		DropDownPage dropdown = wp.clickDropDownLink();

		// Select option
		dropdown.selectOption(option);

		// Get selected option
		String selectedOption = dropdown.getSelectOption();
		assertEquals(selectedOption, expectedOption, "Option 2 is not selected. instead selected - " + selectedOption);
	}

}
