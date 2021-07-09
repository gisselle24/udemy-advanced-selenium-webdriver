package com.herokuapp.theinternet.uploadingfilestests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.UploadingFilesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class UploadingFilesTests extends TestUtilities {

	@Test
	public void uploadFileTest() {
		// open main page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// open "Upload Files" link
		UploadingFilesPage uf = wp.clickFileUploadLink();

		// Select file
		String fileName = "NewFile.xml";
		uf.selectFile(fileName);

		// Push uploaded button
		uf.pushUploadButton();

		// Get uploaded file names
		String fileNames = uf.getUploadedFilesNames();

		// Verify selected file uploaded
		Assert.assertTrue(fileNames.contains(fileName),
				"Our File '" + fileName + " 'is not one of the uploaded '" + fileNames + " '");

	}
}