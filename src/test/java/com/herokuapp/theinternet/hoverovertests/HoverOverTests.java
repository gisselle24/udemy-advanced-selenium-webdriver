package com.herokuapp.theinternet.hoverovertests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverOverPage;

public class HoverOverTests extends TestUtilities {

	@Test
	public void hoverovertest() {
		log.info("Starting hoverovertest");

		// Open page
		HoverOverPage ho = new HoverOverPage(driver, log);
		ho.openPage();
		
		// Open user profile 2
		ho.openProfile(1);
		
		// verify profile opened is correct
		assertTrue(ho.getCurrentUrl().contains("/users/2"), "Url of opened page is not expected User 1 page url");
	}

}
