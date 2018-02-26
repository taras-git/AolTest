package com.letgo.tests.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.letgo.tests.basetests.BaseTestCase;
import com.letgo.tests.utils.Utils;

public class TestCase2 extends BaseTestCase {

	/** The ini file, with values for this testcase */
	String iniFile = "/resources/data/testcases/TestCase2.ini";

	@BeforeMethod
	public void setUp() {
		String browser = Utils.getIniFileValue("browser", iniFile);
		initDriver(browser);
		initWebPages();
	}

	@AfterMethod
	public void tearDown() {
		quit();
	}

	@Test(dependsOnGroups = "testng")
	public void searchForItem() {
		openMainPage();

		String item = Utils.getIniFileValue("item", iniFile);
		mainPage.searchItem(item);
		Assert.assertTrue(mainPage.isItemFound(item), "item: " + item + " not found!");
	}

	@Test(dependsOnGroups = "testng")
	public void searchForItemInWrongGroup() {
		openMainPage();

		mainPage.clickCars();
		String item = Utils.getIniFileValue("item", iniFile);
		mainPage.searchItem(item);
		Assert.assertFalse(mainPage.isItemFound(item), "item: " + item + " not found!");
	}

	@Test(dependsOnGroups = "testng")
	public void uploadPhoto() throws InterruptedException, AWTException {
		openMainPage();

		mainPage.clickSellYourStaff();
		mainPage.clickDragAndDropOrBrowse();

		String pathToPhoto = Utils.getAbsolutePath(//
				Utils.getIniFileValue("photo_path", iniFile))//
				.toString();

		Utils.copyToClipboard(pathToPhoto);
		Utils.pasteFromClipboard();

		mainPage.confirmUploadPhoto();

		// visually verify upload passed
		Thread.sleep(5000);

	}

}
