package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		/**
		 * Open main page
		 */
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		/**
		 * Click on Form Authentication link
		 */
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		/**
		 * Execute logIn
		 */
		SecureAreaPage secureArea = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		/**
		 * verifications.....new url
		 */
		Assert.assertEquals(secureArea.getCurrentUrl(), secureArea.getPageUrl());

		/**
		 * log out button is visible
		 */
		Assert.assertTrue(secureArea.isLogOutButtonVisible(), "logOutButton is not visible.");

		/**
		 * Successful log in message
		 */
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureArea.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
