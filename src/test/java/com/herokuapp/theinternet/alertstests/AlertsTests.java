package com.herokuapp.theinternet.alertstests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptsAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class AlertsTests extends TestUtilities {

	@Test(priority = 1, enabled = true)
	private void jSAlertTest() {
		log.info("Starting jsAlertTest");

		// Open main Page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Click on JavaScript alerts link
		JavaScriptsAlertsPage jSAlert = wp.clickJavaScriptAlertsLink();

		// Click on the button "Click for JS Alert"
		jSAlert.clickJSAlert();

		// Get alert text
		String actualAlertText = jSAlert.getAlertText();

		// Click on button "Aceptar" from JS Alert
		jSAlert.acceptAlert();

		// Get Result text
		String actualResult = jSAlert.getResultText();

		// Verifications
		// 1- Verify alert text is expected
		String expectedAlertText = "I am a JS Alert";
		assertEquals(actualAlertText, expectedAlertText, "Actual alert text is different to expected alert text");

		// 2- Verify message result is "You successfully clicked an alert"
		String expectedResult = "You successfully clicked an alert";
		assertEquals(actualResult, expectedResult, "Actual result is different to expected result text");
	}

	@Test(priority = 2, enabled = true)
	private void jSConfirmButtonAceptTest() {
		// Open main Page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Click on JavaScript alerts link
		JavaScriptsAlertsPage jSAlert = wp.clickJavaScriptAlertsLink();

		// Click on the button "Click for JS Confirm"
		jSAlert.clickJSConfirm();

		// Get alert text
		String actualAlertText = jSAlert.getAlertText();

		// Click on button "Aceptar" from JS Confirm
		jSAlert.acceptAlert();

		// Get Result text
		String actualResult = jSAlert.getResultText();

		// Verifications
		// 1- Verify alert text is expected
		String expectedAlertText = "I am a JS Confirm";
		assertEquals(actualAlertText, expectedAlertText, "Actual alert text is different to expected alert text");

		// 2- Verify message result is "You successfully clicked an alert"
		String expectedResult = "You clicked: Ok";
		assertEquals(actualResult, expectedResult, "Actual result is different to expected result text");
	}

	@Test(priority = 3, enabled = true)
	private void jSConfirmButtonCancelTest() {
		// Open main Page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Click on JavaScript alerts link
		JavaScriptsAlertsPage jSAlert = wp.clickJavaScriptAlertsLink();

		// Click on the button "Click for JS Confirm"
		jSAlert.clickJSConfirm();

		// Click on button "Cancelar" from JS Confirm
		jSAlert.dismissAlert();

		// Verify message result is "You clicked: Cancel"
		// Get Result text
		String actualResult = jSAlert.getResultText();

		// Verification
		// 1- Verify message result is "You successfully clicked an alert"
		String expectedResult = "You clicked: Cancel";
		assertEquals(actualResult, expectedResult, "Actual result is different to expected result text");
	}

	@Test(priority = 4, enabled = true)
	private void jSPromptAceptButtonTest() {
		// Open main Page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Click on JavaScript alerts link
		JavaScriptsAlertsPage jSAlert = wp.clickJavaScriptAlertsLink();

		// Click on the button "Click for JS Prompt"
		jSAlert.clickJSPrompt();

		// Write the word "gisselle" for to verify later
		jSAlert.sendKeysToAlert("Hi I'm testing the alert");

		// Click on button "Aceptar" from JS Prompt
		jSAlert.acceptAlert();

		// Verify message result is "You entered: Hi I'm testing the alert"
		String actualResultText = jSAlert.getResultText();
		String expectedtext = "You entered: Hi I'm testing the alert";
		assertEquals(actualResultText, expectedtext, "Actual result is different to expected result text");
	}

	@Test(priority = 5, enabled = true)
	private void jSPromptCancelButtonTest() {
		// Open main Page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Click on JavaScript alerts link
		JavaScriptsAlertsPage jSAlert = wp.clickJavaScriptAlertsLink();

		// Click on the button "Click for JS Prompt"
		jSAlert.clickJSPrompt();

		// Write the word "gisselle" for to verify later
		jSAlert.sendKeysToAlert("Hi I'm testing the alert");

		// Click on button "Cancelar" from JS Prompt
		jSAlert.dismissAlert();

		// Verify message result is "null"
		String actualResultText = jSAlert.getResultText();
		String expectedtext = "You entered: null";
		assertEquals(actualResultText, expectedtext, "Actual result is different to expected result text");
	}

}
