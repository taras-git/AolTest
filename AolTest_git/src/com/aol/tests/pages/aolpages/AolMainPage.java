package com.aol.tests.pages.aolpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aol.tests.pages.basepage.BasePage;

public class AolMainPage extends BasePage{

	public AolMainPage(WebDriver driver) {
		super(driver);
	}
	
	/** Url for the main Aol page. */
	private String aolUrl = "http://www.aol.com";

	/** Xpath for Aol main page search field. */
	By searchField = By.xpath("(//input[@name=\"q\"])[1]");
	
	/** Xpath for Aol main page search button Submit. */
	By searchButton = By.xpath("(//*[@type=\"submit\"])[1]");
	
	
	/**
	 * Maximize the browser window, set url to www.aol.com and open this url
	 */
	public void openAolPage(){
		maximizeBrowserScreen();
		driver.get(aolUrl);	
	}
	
	/**
	 * Checks if an element is present on the main Aol page by its span text.
	 *
	 * @param text
	 *            the text for span value of the element
	 * @return true, if element is present by its span text
	 */
	public boolean isLinkPresentBySpanText(String text){
		String xpath = ".//span[text()=\""
				+ text
				+ "\"]";
		return isElementPresentByXpath(xpath);
	}
	
	/**
	 * Checks if Search field present on the Aol main page .
	 *
	 * @return true, if is search field present
	 */
	public boolean isSearchFieldPresent(){
		return isElementPresent(searchField);
	}

	public void clickSearchButton(){
		clickElement(searchButton);
	}
	
	/**
	 * Set the search text to Search field and click Search button.
	 *
	 * @param text
	 *            the search text
	 * @return true, if successful
	 */
	public boolean searchAol(String text) {
		if (isSearchFieldPresent()){
			sendText(text, searchField);
			clickSearchButton();
			return true;
		}
		return false;
	}

	/**
	 * Click weather box in left panel on the Aol main page.
	 */
	public void clickWeatherBoxLeftPanel() {
		String weatherBox = "//a[@class=\"m-side-nav__weather-temp\"]";
		clickElement(By.xpath(weatherBox));
	}

	/**
	 * Click weather element in top horizontal panel on the Aol main page.
	 */
	public void clickWeatherElement() {
		String xpath = "//*[@class=\"wthr_ttl\"]";
		clickElement(By.xpath(xpath));
	}

}
