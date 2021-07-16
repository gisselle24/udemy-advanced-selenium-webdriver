package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends BasePageObject {

	private String url = "http://the-internet.herokuapp.com/horizontal_slider";

	private By rangeLocator = By.id("range");
	private By sliderLocator = By.tagName("input");

	public SliderPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void openPage() {
		log.info("Opening Slider page");
		openUrl(url);
		log.info("Slider page is opened");
	}

	public void setSliderTo(String value) throws InterruptedException {
		log.info("Moving slider to: " + value);

		// Move slider normal method
		// Find to xOffset using given value

		/*
		 * int width = find(sliderLocator).getSize().getWidth(); double percent =
		 * Double.parseDouble(value) / 5; int xOffset = (int) (width * percent);
		 * 
		 * Actions action = new Actions(driver);
		 * action.dragAndDropBy(find(sliderLocator), xOffset, 0).build().perform();
		 */

		// Workaround method
		// Calculate numbers of steps

		int steps = (int) (Double.parseDouble(value) / 0.5);

		// Perform steps

		pressKey(sliderLocator, Keys.ENTER);
		
		Thread.sleep(3000);
		
		for (int i = 0; i < steps; i++) {
			pressKey(sliderLocator, Keys.ARROW_RIGHT);
		}

	}

	public String getSliderValue() {
		log.info("Getting slider locator text");
		String sliderText = find(rangeLocator).getText();
		log.info("Text from slider is: " + sliderText);
		return sliderText;
	}

}
