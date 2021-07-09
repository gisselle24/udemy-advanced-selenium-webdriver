package com.herokuapp.theinternet.uploadingfilestests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.UploadingFilesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class UploadingFilesTests extends TestUtilities {

	@Test
	public void uploadFileTest() {
		log.info("Starting uploadFileTest");
		
		// Open main page
		WelcomePageObject wp = new WelcomePageObject(driver, log);
		wp.openPage();

		// Open "Upload Files" link
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
