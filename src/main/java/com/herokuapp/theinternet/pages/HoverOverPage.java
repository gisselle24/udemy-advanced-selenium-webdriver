package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverOverPage extends BasePageObject {

	private String url = "http://the-internet.herokuapp.com/hovers";

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLocator = By.xpath(".//a[contains(text(),'View profile')]");

	public HoverOverPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void openPage() {
		log.info("Opening Hovers page");
		openUrl(url);
		log.info("Hovers page is opened");
	}

	public void openProfile(int i) {
		log.info("Opening profile user 2");
		List<WebElement> avatars = findAll(avatarLocator);
		WebElement specificUserAvatar = avatars.get(i - 1);
		hoverOverElement(specificUserAvatar);
		specificUserAvatar.findElement(viewProfileLocator).click();
		log.info("Hovers page is opened");
	}

}
