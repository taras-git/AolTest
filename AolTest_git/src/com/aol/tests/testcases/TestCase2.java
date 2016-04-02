package com.aol.tests.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aol.tests.basetests.BaseTestCase;
import com.aol.tests.utils.Utils;

public class TestCase2 extends BaseTestCase{

	/** The ini file, with values for this testcase */
	String iniFile = "/resources/data/testcases/TestCase2.ini";

	@BeforeMethod
	public void setUp(){
		initDriver();
		initWebPages();
	}
	
	@AfterMethod
	public void tearDown(){
		quit();
	}
	
	@Test(dependsOnGroups="testng")
	public void testCase2() throws InterruptedException{
		aolMainPage.openAolPage();
		
		// click on weather box in left top panel, or, if it not present, click
		// on weather element in top horizontal panel
		try{
			aolMainPage.clickWeatherBoxLeftPanel();
		} catch (NoSuchElementException e) {
			aolMainPage.clickWeatherElement();
		}
		
		//get new locations city and state from ini file
		String newLocation = Utils.getIniFileValue("aol.weather.location", iniFile);
		String newLocationState = Utils.getIniFileValue("aol.weather.location.state", iniFile);
		aolWeatherPage.setNewLocation(newLocation, newLocationState);
		
		//verify if the webpage correctly displays new location
		if (!aolWeatherPage.isNewLocationWeatherDisplayed(newLocation, newLocationState)){
			Assert.fail("New Location weather is not found!!!");
		} else {
			System.out.println(">>>Found weather for new location");
		}
	}
	
}
