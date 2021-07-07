package com.herokuapp.theinternet.editortests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class EditorTests extends TestUtilities {

	@Test
	public void defaultEditorValueTest() {
		log.info("Starting defaultEditorValueTest");
		
		// open main page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Click on "WYSIWYG Editor" link witch open new page WYSIWYG Editor
		EditorPage ep = wp.clickWYSIWYGEditor();

		// Get default editor text
		String editorText = ep.getEditorText();

		// Verification that new page contains expected text in source
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default textis not expected. It is: " + editorText);
	}
}
