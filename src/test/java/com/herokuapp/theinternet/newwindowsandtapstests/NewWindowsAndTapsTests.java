package com.herokuapp.theinternet.newwindowsandtapstests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowPage;
import com.herokuapp.theinternet.pages.NewWindow;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NewWindowsAndTapsTests extends TestUtilities {

	@Test
	public void name() {

		// open main page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// click on "Multiple Windows" link on Welcome page, witch get the new window
		MultipleWindowPage mw = wp.clickMultipleWindowLink();

		// click on the "Click here" link witch open a new tap
		mw.openNewWindow();

		// Find and switch to new window
		NewWindow nw = mw.switchToNewWindowPage();

		String pagesource = nw.getCurrentPageSource();

		// verification
		// verify that new page contains expected text in source
		String newWindowText = "New Window";
		assertTrue(pagesource.contains(newWindowText), "New window does not contain the text: " + newWindowText);

	}
}
