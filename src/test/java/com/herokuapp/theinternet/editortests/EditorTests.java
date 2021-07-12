package com.herokuapp.theinternet.editortests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class EditorTests extends TestUtilities {

	@Test
	public void defaultEditorValueTest() {
		log.info("Starting defaultEditorValueTest");

		// open main page
		WelcomePage wp = new WelcomePage(driver, log);
		wp.openPage();

		// Scroll with Java Script Executor
		sleep(5000);
		wp.scrollToWYSIWYGEditorLink();
		sleep(5000);

		// Click on "WYSIWYG Editor" link witch open new page WYSIWYG Editor
		EditorPage ep = wp.clickWYSIWYGEditor();

		// Get default editor text
		String editorText = ep.getEditorText();

		// Verification that new page contains expected text in source
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default textis not expected. It is: " + editorText);
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
