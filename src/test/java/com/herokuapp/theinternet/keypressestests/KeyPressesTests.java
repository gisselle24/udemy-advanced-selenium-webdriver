package com.herokuapp.theinternet.keypressestests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressesTests extends TestUtilities {

	@Test
	public void pressKeyTest() {

		// open main page
		WelcomePage wp = new WelcomePage(driver, log);
		wp.openPage();

		// click on "KeyPresses" link
		KeyPressesPage kp = wp.clickPressesKey();

		// push keyboard key
		kp.pushKeyboardKey(Keys.ENTER);

		// get result text
		String actualResult = kp.getResultText();
		String expectedResult = "You entered: ENTER";

		// verify result text is expected
		assertEquals(actualResult, expectedResult, "The text result is not the expected");
	}

	@Test
	public void pressKeyWithActionsTest() {

		// open main page
		WelcomePage wp = new WelcomePage(driver, log);
		wp.openPage();

		// click on "KeyPresses" link
		KeyPressesPage kp = wp.clickPressesKey();

		// push keyboard key
		kp.pressKeyWithActionClass(Keys.SPACE);

		// get result text
		String actualResult = kp.getResultText();
		String expectedResult = "You entered: SPACE";

		// verify result text is expected
		assertEquals(actualResult, expectedResult, "The text result is not the expected");
	}
}
