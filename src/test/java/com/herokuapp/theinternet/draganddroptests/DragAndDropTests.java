package com.herokuapp.theinternet.draganddroptests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

public class DragAndDropTests extends TestUtilities {

	@Test
	public void dragAToBtest() {
		log.info("Starting dragAToBtest");

		// open page Drag and drop
		DragAndDropPage ddp = new DragAndDropPage(driver, log);
		ddp.openPageDragAndDrop();

		// drag A to B
		sleep(3000);
		ddp.dragAtoB();
		sleep(3000);

		// Verify A was drag to B
		String columnAText = ddp.getTextFromColumnA();
		assertTrue(columnAText.contains("B"), "Column A header should be B text");

		String columnBText = ddp.getTextFromColumnB();
		assertTrue(columnBText.contains("A"), "Column B header should be A text");

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
