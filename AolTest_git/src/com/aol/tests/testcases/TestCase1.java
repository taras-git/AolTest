package com.aol.tests.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aol.tests.basetests.BaseTestCase;
import com.aol.tests.utils.Utils;

public class TestCase1 extends BaseTestCase {
	
	/** The ini file, with values for this testcase */
	String iniFile = "/resources/data/testcases/TestCase1.ini";

	@BeforeMethod
	public void setUp() {
		initDriver();
		initWebPages();
	}

	@AfterMethod
	public void tearDown() {
		quit();
	}

	@Test(dependsOnGroups="testng")
	public void testCase1() throws InterruptedException {
		aolMainPage.openAolPage();
		
		//check the title of the main Aol page if it is the same as in ini file
		//this check is optional, can be commented out
		String aolMainTitle = Utils.getIniFileValue("aol.title", iniFile);
		String actualTitle = aolMainPage.getActualTitle();
		System.out.println(">>>Title from ini file:" + aolMainTitle);
		System.out.println(">>>Title from browser :" + actualTitle);
		Assert.assertEquals(actualTitle, aolMainTitle);

		// get a string with links text from the testcase ini file and make an array
		// by splitting the string by comma
		String[] linksText = Utils.getIniFileValue("aol.links.text", iniFile).split(",");
		
		// get a string with links ids from the testcase ini file and make an
		// array by splitting the string by comma
		String[] linksId = Utils.getIniFileValue("aol.links.id", iniFile).split(",");
		
		// iterate over each link, check if the link is found on the Aol main page
		try {
			//verify links if they are displayed in top horizontal panel 
			verifyAolMainPageLinksById(linksId);
		} catch (NoSuchElementException e) {
			//verify links are displayed in left vertical panel
			verifyAolMainPageLinksByText(linksText);
		}
		
		//get the search string from testcase ini file
		String autoBlog = Utils.getIniFileValue("aol.search.string", iniFile);
		
		//set the search string to Aol search field
		aolMainPage.searchAol(autoBlog);

		//check if link Web is present on resulting search page
		if (!aolSearchPage.isWebLinkPresent()){
			Assert.fail("Link Web is not found!!!");
		} else {
			System.out.println(">>>Found link: Web");
		}
		
		//check if link Mail is present on resulting search page
		if (!aolSearchPage.isMailLinkPresent()){
			Assert.fail("Link Mail is not found!!!");
		} else {
			System.out.println(">>>Found link: Mail");
		}
		
		//click on Auto blog link and open it in new tab
		aolSearchPage.clickAutoBlog();
		
		//check if Auto blog logo is present in new tab
		if (!autoBlogPage.isLogoPresent()){
			Assert.fail("AutoBlog page logo is not found!!!");
		} else {
			System.out.println(">>>Found AutoBlog logo");
		}
		
	}

	/**
	 * Iterates over the array with links span names, and verify if the link is
	 * present on web page, in vertical left panel
	 *
	 * @param links
	 *            the array with links span text
	 */
	private void verifyAolMainPageLinksByText(String[] links) {
		for (String link : links) {
			if (!aolMainPage.isLinkPresentBySpanText(link)) {
				throw new NoSuchElementException("Link: " + link + " is not found!!!");
			} else {
				System.out.println(">>>Found link by span text: " + link);
			}
		}
	}
		
	
	/**
	 * iterates over the array with links id, and verify if the link is present
	 * on web page, in top horizontal panel
	 * 
	 * @param links
	 *            the array with links id
	 */
	private void verifyAolMainPageLinksById(String[] links) {
		for (String link : links) {
			if (!aolMainPage.isElementPresentById(link)) {
				throw new NoSuchElementException("Link: " + link + " is not found!!!");
			} else {
				System.out.println(">>>Found link by id: " + link);
			}
		}
	}
}
