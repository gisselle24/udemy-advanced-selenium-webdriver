package com.herokuapp.theinternet.uploadingfilestests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.UploadingFilesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class UploadingFilesTests extends TestUtilities {

	@Test(dataProvider = "files")
	public void fileUploadTest(int no, String fileName) {
		log.info("Starting upload Files Test using DataProvider");
		
		// Open main page
		WelcomePage wp = new WelcomePage(driver, log);
		wp.openPage();

		// Open "Upload Files" link
		UploadingFilesPage uf = wp.clickFileUploadLink();

		// Select file
		
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
