package com.letgo.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.letgo.tests.basetests.BaseTestCase;
import com.letgo.tests.utils.Utils;

public class TestCase1 extends BaseTestCase {

	/** The ini file, with values for this testcase */
	String iniFile = "/resources/data/testcases/TestCase1.ini";

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
	public void signUp() {
		mainPage.openMainPage();

		// check the title of the main page if it is the same as in ini file
		// this check is optional, can be commented out
		String mainPageTitle = Utils.getIniFileValue("title", iniFile);
		String actualPageTitle = mainPage.getActualTitle();
		System.out.println(">>>Title from ini file:" + mainPageTitle);
		System.out.println(">>>Title from browser :" + actualPageTitle);
		Assert.assertEquals(actualPageTitle, mainPageTitle);

		waitForPageLoaded();
		mainPage.clickStayInUS();
		mainPage.logIn();
		mainPage.signUp();
	}

}
