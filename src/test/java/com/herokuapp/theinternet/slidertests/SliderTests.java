package com.herokuapp.theinternet.slidertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.SliderPage;

public class SliderTests extends TestUtilities {

	@Test
	public void sliderTest() throws InterruptedException {
		log.info("Starting slider test");

		// Open slider page
		SliderPage sp = new SliderPage(driver, log);
		sp.openPage();

		// Move slider to right
		String value = "3.5";

		sleep(3000);
		sp.setSliderTo(value);
		sleep(3000);

		// Verify slider value
		String actualValue = sp.getSliderValue();
		Assert.assertEquals(actualValue, value, "Range is not correct");
	}

	public void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
