package com.herokuapp.theinternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

	protected void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DataProvider(name = "files")
	protected static Object[][] files() {
		return new Object[][] { { 1, "index.xml" }, { 2, "logo.jpeg" }, { 3, "text.txt" }, };
	}
}
