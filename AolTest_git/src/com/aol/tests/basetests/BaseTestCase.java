package com.aol.tests.basetests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aol.tests.pages.aolpages.AolMainPage;
import com.aol.tests.pages.aolpages.AolSearchPage;
import com.aol.tests.pages.aolpages.AolWeatherPage;
import com.aol.tests.pages.autoblogpages.AutoBlogPage;
import com.aol.tests.utils.Utils;

public class BaseTestCase {

	private WebDriver driver;

	/** The ini file with values for current class. */
	String iniFile = "/resources/config/testStation.ini";	
	
	/** The value of implicitly wait seconds, until webelement found */
	String waitSeconds = Utils.getIniFileValue("implicitly.wait.seconds", iniFile);	

	public AolMainPage 		aolMainPage;
	public AolSearchPage 	aolSearchPage;
	public AutoBlogPage 	autoBlogPage;
	public AolWeatherPage	aolWeatherPage;
	
	public void initWebPages(){
		aolMainPage 		= new AolMainPage(driver);
		aolSearchPage		= new AolSearchPage(driver);
		autoBlogPage		= new AutoBlogPage(driver);
		aolWeatherPage		= new AolWeatherPage(driver);
	}
	
	/**
	 * Quit all open Webdrivers windows.
	 */
	public void quit(){
		driver.quit();
	}
	
	/**
	 * Close current Webdriver window
	 */
	public void close(){
		driver.close();
	}
	
	/**
	 * Inits the Firefox Webdriver and sets the value of implicitly wait seconds.
	 *
	 * @return the Webdriver
	 */
	public WebDriver initDriver(){
		driver =  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(waitSeconds), TimeUnit.SECONDS);
		return driver;
	}

}

