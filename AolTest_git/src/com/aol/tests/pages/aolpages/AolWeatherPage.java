package com.aol.tests.pages.aolpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aol.tests.pages.basepage.BasePage;

public class AolWeatherPage extends BasePage{

	public AolWeatherPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Sets the new location city to the search field and click on the city with
	 * state in the dropdown menu.
	 *
	 * @param newLocation
	 *            the new location city
	 * @param newLocationState
	 *            the new location state
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void setNewLocation(String newLocation, String newLocationState) throws InterruptedException {
		String xpath = "//input[@class=\"location-search-input\"]";
		sendText(newLocation, By.xpath(xpath));
		String a = "//a[contains(text(),\""
				+ newLocation
				+ ", "
				+ newLocationState
				+ "\")]";
		clickElement(By.xpath(a));
	}
	
	/**
	 * Checks if new location city and state is displayed on Aol weather page.
	 *
	 * @param newLocation
	 *            the new location city
	 * @param newLocationState
	 *            the new location state
	 * @return true, if new location is displayed on weather page
	 */
	public boolean isNewLocationWeatherDisplayed(String newLocation, String newLocationState){
		String xpath = ".//span[@data-fullstatecountry=\""
				+ newLocationState
				+ "\" and @data-fullname=\""
				+ newLocation
				+ "\"]";
		if (isElementPresentByXpath(xpath)){
			return true;
		}
		return false;
	}

}
